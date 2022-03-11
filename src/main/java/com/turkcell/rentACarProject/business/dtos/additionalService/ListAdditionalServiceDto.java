package com.turkcell.rentACarProject.business.dtos.additionalService;

import com.turkcell.rentACarProject.business.dtos.additionalServiceItem.ListAdditionalServiceItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAdditionalServiceDto {
	private int id;
	private int rentalId;
	private int additionalServiceItemId;
}
