package com.turkcell.rentACarProject.business.requests.creditCardDetails;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardDetailsRequest {
	
	private String cardNumber;
	private int customerId;
	private String cardHolder;
	private int cVV;
	private LocalDate expirationDate;
}
