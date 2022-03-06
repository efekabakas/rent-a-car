package com.turkcell.rentACarProject.business.requests.rental;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

    private LocalDate rentDate;

    private int customerId;
    private int carId;


}