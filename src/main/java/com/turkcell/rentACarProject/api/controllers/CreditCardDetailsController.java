package com.turkcell.rentACarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.rentACarProject.business.abstracts.CreditCardDetailsService;
import com.turkcell.rentACarProject.business.dtos.creditCardDetails.ListCreditCardDetailsDto;
import com.turkcell.rentACarProject.business.requests.creditCardDetails.CreateCreditCardDetailsRequest;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/creditCardDetails")
public class CreditCardDetailsController {
	
	private CreditCardDetailsService creditCardDetailsService;

	@Autowired
	public CreditCardDetailsController(CreditCardDetailsService creditCardDetailsService) {
		
		this.creditCardDetailsService = creditCardDetailsService;
	}
	
	@GetMapping("/get")
	DataResult<ListCreditCardDetailsDto> getById(@RequestParam int id) {
		
		return creditCardDetailsService.getById(id);
	}
	
	@GetMapping("/getAll")
	DataResult<List<ListCreditCardDetailsDto>> getAll() {
		
		return creditCardDetailsService.getAll();
		
	}
	
	@GetMapping("/getAllByCustomerId")
	DataResult<List<ListCreditCardDetailsDto>> getAllByCustomerId(@RequestParam int customerId) {
		
		return creditCardDetailsService.getAllByCustomerId(customerId);
	}
	
	@PostMapping("/create")
	Result create(@RequestBody CreateCreditCardDetailsRequest cardDetailsRequest) throws BusinessException {
		
		return creditCardDetailsService.create(cardDetailsRequest);	
	}
	

}
