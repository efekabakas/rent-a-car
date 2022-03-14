package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.individualCustomer.ListIndividualCustomerDto;
import com.turkcell.rentACarProject.business.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface IndividualCustomerService {
	DataResult<List<ListIndividualCustomerDto>> getAll();
	DataResult<ListIndividualCustomerDto> getById(int id);
	Result create(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws BusinessException;
}
