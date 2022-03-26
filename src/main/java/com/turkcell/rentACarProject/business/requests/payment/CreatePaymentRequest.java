package com.turkcell.rentACarProject.business.requests.payment;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.turkcell.rentACarProject.business.requests.creditCardDetails.CreateCreditCardDetailsRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {

	@NotNull
	private LocalDate paymentDate;
	private int rentalId;
	private CreateCreditCardDetailsRequest createCreditCardDetailsRequest;
	private double amount;
	private boolean saveCreditCard;
}
