package com.pavelrybakov.warehouse.services.impl;

import com.pavelrybakov.warehouse.dao.CompanyDao;
import com.pavelrybakov.warehouse.dao.HouseDao;
import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.domains.House;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;
import com.pavelrybakov.warehouse.services.HouseService;
import org.mybatis.guice.transactional.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import static com.pavelrybakov.warehouse.exceptions.WarehouseException.companyNotFound;

public class HouseServiceImpl implements HouseService {

    @Inject @NotNull HouseDao houseDao;

    @Override
    @NotNull
    @Transactional
    public House createHouse(@NotNull Company company, @NotNull String name) {
        House house = new House(company, name);

        houseDao.insertHouse(house);
        return house;
    }

    @Override
    @Nullable
    public House findHouse(int id) {
        return houseDao.find(id);
    }

    @Override
    @NotNull
    public House getHouse(int id) throws WarehouseException {
        House house = houseDao.find(id);
        if (null == house) {
            throw companyNotFound(id);
        }

        return house;
    }

    @Override
    @Transactional
    public void deleteHouse(@NotNull House house) {
        houseDao.deleteHouse(house.getId());
    }

    @Override
    @Transactional
    public void updateHouse(@NotNull House house) {
        houseDao.updateHouse(house);
    }
}
