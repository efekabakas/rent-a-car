package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.creditCardDetails.ListCreditCardDetailsDto;
import com.turkcell.rentACarProject.business.requests.creditCardDetails.CreateCreditCardDetailsRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface CreditCardDetailsService {
	
	DataResult<List<ListCreditCardDetailsDto>> getAll();
	DataResult<ListCreditCardDetailsDto> getById(int id);
	Result create(CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException;

}
