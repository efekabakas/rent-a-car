package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.rental.ListRentalDto;
import com.turkcell.rentACarProject.business.requests.rental.CreateRentalRequest;
import com.turkcell.rentACarProject.business.requests.rental.DeleteRentalRequest;
import com.turkcell.rentACarProject.business.requests.rental.UpdateRentalRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface RentalService {
	
	Result createForCorporateCustomer(CreateRentalRequest createRentalRequest) throws BusinessException;  
	Result createForIndividualCustomer(CreateRentalRequest createRentalRequest) throws BusinessException;  	
	Result delete(DeleteRentalRequest deleteCarRequest);
	Result update(UpdateRentalRequest updateCarRequest);
	Result isCarRented(int carId) throws BusinessException;
	
	DataResult<List<ListRentalDto>> getAll();
	DataResult<ListRentalDto> getById(int id);

}
