package com.turkcell.rentACarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.business.abstracts.AdditionalServiceItemService;
import com.turkcell.rentACarProject.business.dtos.additionalServiceItem.ListAdditionalServiceItemDto;
import com.turkcell.rentACarProject.business.requests.additionalServiceItem.CreateAdditionalServiceItemRequest;
import com.turkcell.rentACarProject.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.ErrorDataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;
import com.turkcell.rentACarProject.core.utilities.results.SuccessDataResult;
import com.turkcell.rentACarProject.core.utilities.results.SuccessResult;
import com.turkcell.rentACarProject.dataAccess.abstracts.AdditionalServiceItemDao;
import com.turkcell.rentACarProject.entities.concretes.AdditionalServiceItem;

@Service
public class AdditionalServiceItemManager implements AdditionalServiceItemService {

	private ModelMapperService modelMapperService;
	private AdditionalServiceItemDao additionalServiceItemDao;

	@Autowired
	public AdditionalServiceItemManager(ModelMapperService modelMapperService,
			AdditionalServiceItemDao additionalServiceItemDao) {

		this.modelMapperService = modelMapperService;
		this.additionalServiceItemDao = additionalServiceItemDao;
	}

	@Override
	public Result add(CreateAdditionalServiceItemRequest createAdditionalServiceItemRequest) {
		AdditionalServiceItem additionalServiceItem = this.modelMapperService.forRequest().map(createAdditionalServiceItemRequest, AdditionalServiceItem.class);
		this.additionalServiceItemDao.save(additionalServiceItem);
		return new SuccessResult("");
	}

	@Override
	public DataResult<ListAdditionalServiceItemDto> findById(int id) {
		if(additionalServiceItemDao.existsById(id)) {
			AdditionalServiceItem item = additionalServiceItemDao.findById(id).get();
			ListAdditionalServiceItemDto response = modelMapperService.forDto().map(item, ListAdditionalServiceItemDto.class);
			return new SuccessDataResult<ListAdditionalServiceItemDto>(response);
		}else return new ErrorDataResult<ListAdditionalServiceItemDto>();
	}

	@Override
	public DataResult<List<ListAdditionalServiceItemDto>> getAll() {
		
		var result = this.additionalServiceItemDao.findAll();
		
		List<ListAdditionalServiceItemDto> response = result.stream()
				.map(additionalServiceItem -> this.modelMapperService.forDto().map(additionalServiceItem, ListAdditionalServiceItemDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListAdditionalServiceItemDto>>(response);
	}

	
	
}
