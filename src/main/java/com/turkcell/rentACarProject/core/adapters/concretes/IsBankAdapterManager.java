package com.turkcell.rentACarProject.core.adapters.concretes;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.turkcell.rentACarProject.core.adapters.abstracts.BankAdapterService;
import com.turkcell.rentACarProject.core.exceptions.BusinessException;
import com.turkcell.rentACarProject.core.externalServices.banks.IsBank;
import com.turkcell.rentACarProject.core.utilities.results.Result;
import com.turkcell.rentACarProject.core.utilities.results.SuccessResult;

@Service
@Primary
public class IsBankAdapterManager implements BankAdapterService{

	@Override
	public Result checkIfLimitIsEnough(String cardNo, String year, String mounth, String cVV, double amount) {
		IsBank isBank= new IsBank();
		if(isBank.isLimitExists(cardNo, year, mounth, cVV, amount))	{
			return new SuccessResult("İsBank pos işlemi yapıldı.");
		}
		else {
			throw new BusinessException("Limit yetersiz");
		}
	}

}
