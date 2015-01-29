package com.pavelrybakov.warehouse.services;

import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public interface CompanyService {

    @NotNull Company createCompany(@NotNull String name) throws WarehouseException;

    @Nullable Company findCompany(int id);

    @NotNull Company getCompany(int id) throws WarehouseException;

    void deleteCompany(@NotNull Company company);

    void updateCompany(@NotNull Company company);
}
