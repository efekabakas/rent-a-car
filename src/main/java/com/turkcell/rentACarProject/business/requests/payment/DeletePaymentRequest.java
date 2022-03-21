package com.turkcell.rentACarProject.business.requests.payment;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletePaymentRequest {
	
	@NotNull
	private int paymentId;

}
