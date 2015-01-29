package com.pavelrybakov.warehouse.services;

import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.domains.House;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public interface HouseService {

    @NotNull House createHouse(@NotNull Company company, @NotNull String name);

    @Nullable House findHouse(int id);

    @NotNull House getHouse(int id) throws WarehouseException;

    void deleteHouse(@NotNull House house);

    void updateHouse(@NotNull House house);
}
