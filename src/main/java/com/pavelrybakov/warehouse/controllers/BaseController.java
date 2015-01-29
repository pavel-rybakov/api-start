package com.pavelrybakov.warehouse.controllers;

import com.pavelrybakov.warehouse.services.CompanyService;
import com.pavelrybakov.warehouse.services.HouseService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

public class BaseController {

    @Inject @NotNull protected CompanyService companyService;
    @Inject @NotNull protected HouseService houseService;

}
