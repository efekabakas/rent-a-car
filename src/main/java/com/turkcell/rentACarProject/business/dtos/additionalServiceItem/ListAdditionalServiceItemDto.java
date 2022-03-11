package com.turkcell.rentACarProject.business.dtos.additionalServiceItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListAdditionalServiceItemDto {
	private int id;
	private String name;
	private double price;
}
