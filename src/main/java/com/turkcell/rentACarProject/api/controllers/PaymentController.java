package com.turkcell.rentACarProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.rentACarProject.business.abstracts.PaymentService;
import com.turkcell.rentACarProject.business.dtos.payment.ListPaymentDto;
import com.turkcell.rentACarProject.business.requests.payment.CreatePaymentRequest;
import com.turkcell.rentACarProject.business.requests.payment.DeletePaymentRequest;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;



@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	private PaymentService paymentService ;
	
	@Autowired	
	public PaymentController(PaymentService paymentService) {		
		this.paymentService = paymentService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreatePaymentRequest createPaymentRequest)  {
		return this.paymentService.add(createPaymentRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeletePaymentRequest deletePaymentRequest)  {
		return this.paymentService.delete(deletePaymentRequest);
	}


	@GetMapping("/getAll")
	public DataResult<List<ListPaymentDto>> getAll() {
		return this.paymentService.getAll();
	}

	@PostMapping("/getAllPaged")
	public DataResult<List<ListPaymentDto>> getAllPaged(int pageNo, int pageSize) {
		return this.paymentService.getAllPaged(pageNo, pageSize);
	}

	@GetMapping("/getPaymentByRentalId")
	public DataResult<ListPaymentDto> getByRentalId(int rentalId)  {
		return this.paymentService.getByRentalId(rentalId);
	}

}
