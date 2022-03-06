package com.turkcell.rentACarProject.business.requests.carMaintenance;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarMaintenanceRequest {
	private String description;
	private int id;
	private LocalDate returnDate;
	private int carId;
}
