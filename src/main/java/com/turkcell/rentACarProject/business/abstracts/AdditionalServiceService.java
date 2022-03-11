package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.additionalService.ListAdditionalServiceDto;
import com.turkcell.rentACarProject.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface AdditionalServiceService {

	DataResult<List<ListAdditionalServiceDto>> findAllByRentalId(int rentalId);
	
	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	
	// update 
	// delete
	
}
