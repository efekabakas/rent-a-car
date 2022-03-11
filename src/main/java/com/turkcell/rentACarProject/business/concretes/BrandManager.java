package com.turkcell.rentACarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.business.abstracts.BrandService;
import com.turkcell.rentACarProject.business.dtos.brand.ListBrandDto;
import com.turkcell.rentACarProject.business.requests.brand.CreateBrandRequest;
import com.turkcell.rentACarProject.business.requests.brand.DeleteBrandRequest;
import com.turkcell.rentACarProject.business.requests.brand.UpdateBrandRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACarProject.dataAccess.abstracts.BrandDao;
import com.turkcell.rentACarProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListBrandDto> getAll() {
		var result = this.brandDao.findAll();
		List<ListBrandDto> response = result.stream()
				.map(brand -> this.modelMapperService.forDto().map(brand, ListBrandDto.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void create(CreateBrandRequest createBrandRequest) throws BusinessException {

		checkIfBrandExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandDao.save(brand);
	}

	@Override
	public ListBrandDto getById(int id) throws BusinessException { // Result
		Brand result = this.brandDao.getBrandById(id);
		/*
		 * if (result==null) { return new ErrorDataResult<>(); }
		 */
		ListBrandDto response = this.modelMapperService.forDto().map(result, ListBrandDto.class);
		return response;

	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandDao.delete(brand);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);

	}

	private void checkIfBrandExists(String brandName) throws BusinessException {
		if (this.brandDao.getBrandByName(brandName).stream().count() != 0) {
			throw new BusinessException("Brand already exists!");
		}
	}
}
