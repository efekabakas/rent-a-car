package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.additionalServiceItem.ListAdditionalServiceItemDto;
import com.turkcell.rentACarProject.business.requests.additionalServiceItem.CreateAdditionalServiceItemRequest;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface AdditionalServiceItemService {

	Result add(CreateAdditionalServiceItemRequest createAdditionalServiceItemRequest);
	DataResult<ListAdditionalServiceItemDto> findById(int id);
	DataResult<List<ListAdditionalServiceItemDto>> getAll();
	
}
