package com.turkcell.rentACarProject.business.dtos.payment;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPaymentDto {
	
	private int id;	
	private double totalPayment;	
	private LocalDate paymentDate;
	private int rentalId;	
}
