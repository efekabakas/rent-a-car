package com.turkcell.rentACarProject.core.adapters.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.core.adapters.abstracts.BankAdapterService;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.externalServices.banks.GarantiBank;
import com.turkcell.rentACarProject.core.utilities.results.Result;
import com.turkcell.rentACarProject.core.utilities.results.SuccessResult;





@Service
@Qualifier("garantiBank")
public class GarantiBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(String cardNo, String year, String mounth, String cVV, double amount) {
		
		GarantiBank garantiBank = new GarantiBank();
		if(garantiBank.isLimitExists(cardNo, year, mounth, cVV, amount))	{
			return new SuccessResult("Garanti pos işlemi yapıldı.");
		}
		else {
			throw new BusinessException("Limit yetersiz");
		}
	}

}
