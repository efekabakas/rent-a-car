package com.turkcell.rentACarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.business.abstracts.ColorService;
import com.turkcell.rentACarProject.business.dtos.color.ListColorDto;
import com.turkcell.rentACarProject.business.requests.color.CreateColorRequest;
import com.turkcell.rentACarProject.business.requests.color.DeleteColorRequest;
import com.turkcell.rentACarProject.business.requests.color.UpdateColorRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACarProject.dataAccess.abstracts.ColorDao;
import com.turkcell.rentACarProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListColorDto> getAll() {

		var result = colorDao.findAll();

		List<ListColorDto> response = result.stream()
				.map(color -> modelMapperService.forDto().map(color, ListColorDto.class)).collect(Collectors.toList());

		return response;
	}

	@Override
	public void create(CreateColorRequest createColorRequest) throws BusinessException {

		Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);
		checkIfColorExists(color);

		this.colorDao.save(color);
	}

	@Override
	public ListColorDto getById(int id) {

		Color result = colorDao.getColorById(id);
		ListColorDto response = modelMapperService.forDto().map(result, ListColorDto.class);

		return response;
	}

	@Override
	public void delete(DeleteColorRequest deleteColorRequest) {

		Color color = modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		colorDao.delete(color);
	}

	@Override
	public void update(UpdateColorRequest updateColorRequest) {
		Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
		colorDao.save(color);
	}

	void checkIfColorExists(Color color) throws BusinessException {

		if (colorDao.getColorByName(color.getName()).stream().count() != 0) {
			throw new BusinessException("Color already exists.");
		}
	}
}
