package com.turkcell.rentACarProject.business.abstracts;

import java.util.List;

import com.turkcell.rentACarProject.business.dtos.carDamage.ListCarDamageDto;
import com.turkcell.rentACarProject.business.requests.carDamage.CreateCarDamageRequest;
import com.turkcell.rentACarProject.business.requests.carDamage.UpdateCarDamageRequest;
import com.turkcell.rentACarProject.core.utilities.results.DataResult;
import com.turkcell.rentACarProject.core.utilities.results.Result;

public interface CarDamageService {

    DataResult<List<ListCarDamageDto>> getAll();
    DataResult<List<ListCarDamageDto>> getAllByCarId(int id);
    Result create(CreateCarDamageRequest createCarDamageRequest);
    Result update(UpdateCarDamageRequest updateCarDamageRequest);
    Result delete(int id);
}
