package com.turkcell.rentACarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.business.abstracts.AdditionalServiceService;
import com.turkcell.rentACarProject.business.abstracts.RentalService;
import com.turkcell.rentACarProject.business.constants.Messages;
import com.turkcell.rentACarProject.business.dtos.additionalService.ListAdditionalServiceDto;
import com.turkcell.rentACarProject.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.turkcell.rentACarProject.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;
import com.turkcell.rentACarProject.core.utilities.results.SuccessDataResult;
import com.turkcell.rentACarProject.core.utilities.results.SuccessResult;
import com.turkcell.rentACarProject.dataAccess.abstracts.AdditionalServiceDao;
import com.turkcell.rentACarProject.entities.concretes.OrderedAdditionalService;
@Service
public class AdditionalServiceManager implements AdditionalServiceService{
	
	private AdditionalServiceDao additionalServiceDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;
	
	
	
	@Autowired
	public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService,
			RentalService rentalService) {
		super();
		this.additionalServiceDao = additionalServiceDao;
		this.modelMapperService = modelMapperService;
		this.rentalService = rentalService;
	}
	
	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		OrderedAdditionalService additionalService = this.modelMapperService.forRequest().map(createAdditionalServiceRequest, OrderedAdditionalService.class);
		
		additionalService.setId(0);
		this.additionalServiceDao.save(additionalService);
		return new SuccessResult("sss");
	}

	@Override
	public DataResult<List<ListAdditionalServiceDto>> findAllByRentalId(int rentalId) {
		List<OrderedAdditionalService> additionalServiceList = this.additionalServiceDao.findAllByRentalId(rentalId);
		List<ListAdditionalServiceDto> response = additionalServiceList.stream().map(
				additionalService -> modelMapperService.forDto().map(additionalService, ListAdditionalServiceDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListAdditionalServiceDto>>(response);
	}
	
	/*private Result checkIfRentalExists(int rentalId) {
		if (!rentalService.findBy(rentalId).isSuccess()) {
			return new ErrorResult(Messages.rentalIsNotFound);
		} else
			return new SuccessResult();
	}*/

	

}
