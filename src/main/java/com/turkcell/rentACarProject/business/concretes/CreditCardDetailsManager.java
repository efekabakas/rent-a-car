package com.turkcell.rentACarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.business.abstracts.CreditCardDetailsService;
import com.turkcell.rentACarProject.business.constants.Messages;
import com.turkcell.rentACarProject.business.dtos.creditCardDetails.ListCreditCardDetailsDto;
import com.turkcell.rentACarProject.business.requests.creditCardDetails.CreateCreditCardDetailsRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.ErrorDataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;
import com.turkcell.rentACarProject.core.utilities.results.SuccessDataResult;
import com.turkcell.rentACarProject.core.utilities.results.SuccessResult;
import com.turkcell.rentACarProject.dataAccess.abstracts.CreditCardDetailsDao;
import com.turkcell.rentACarProject.entities.concretes.CreditCardDetails;


@Service
public class CreditCardDetailsManager implements CreditCardDetailsService {

	CreditCardDetailsDao creditCardDetailsDao;
	ModelMapperService modelMapperService;
	
	@Autowired
	public CreditCardDetailsManager(CreditCardDetailsDao cardDetailsDao, ModelMapperService mapperService) {
		this.creditCardDetailsDao = cardDetailsDao;
		this.modelMapperService = mapperService;
	}

	@Override
	public DataResult<List<ListCreditCardDetailsDto>> getAll() {
		
		var result = this.creditCardDetailsDao.findAll();
		
		List<ListCreditCardDetailsDto> response = result.stream()
				.map(creditCardDetails -> this.modelMapperService.forDto().map(creditCardDetails, ListCreditCardDetailsDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCreditCardDetailsDto>>(response);
	}

	@Override
	public DataResult<ListCreditCardDetailsDto> getById(int id) {

		CreditCardDetails result = this.creditCardDetailsDao.getById(id);
		
		if(result == null) {
			
			return new ErrorDataResult<ListCreditCardDetailsDto>("Car.NotFound");
		}
		
		ListCreditCardDetailsDto response = this.modelMapperService.forDto().map(result, ListCreditCardDetailsDto.class);
		
		return new SuccessDataResult<ListCreditCardDetailsDto>(response);
	}

	@Override
	public Result create(CreateCreditCardDetailsRequest createCreditCardDetailsRequest) throws BusinessException {
		
		CreditCardDetails creditCardDetails = this.modelMapperService.forRequest().map(createCreditCardDetailsRequest, CreditCardDetails.class);
		
		this.creditCardDetailsDao.save(creditCardDetails);
		
		return new SuccessResult(Messages.CreditCardAdded);
	}

}
