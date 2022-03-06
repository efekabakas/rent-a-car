package com.turkcell.rentACarProject.business.abstracts;

import com.turkcell.rentACarProject.business.requests.rental.CreateRentalRequest;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface RentalService {
	
	Result add(CreateRentalRequest createRentalRequest);
}
