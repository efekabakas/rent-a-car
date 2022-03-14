package com.turkcell.rentACarProject.business.requests.additionalServiceItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalServiceItemRequest {

	private String name;
	private double price;
	
}
