package com.turkcell.rentACarProject.business.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {

	private int carId;
	private double carDailyPrice;
	private int carModelYear;
	private String carDescription;
	private String brandName;
	private String colorName;
    private int mileage;
}
