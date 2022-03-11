package com.turkcell.rentACarProject.business.requests.additionalService;

import com.turkcell.rentACarProject.business.requests.brand.CreateBrandRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceRequest {
	
	private int rentalId;
	private int additionalServiceItemId;

}
