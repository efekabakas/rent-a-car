package com.turkcell.rentACarProject.core.adapters.abstracts;

import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface BankAdapterService {

	Result checkIfLimitIsEnough(String cardNo, String year, String month, String cVV, double amount);

}
