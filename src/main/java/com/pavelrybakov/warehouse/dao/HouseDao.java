package com.pavelrybakov.warehouse.dao;

import com.pavelrybakov.warehouse.domains.House;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface HouseDao {

    @Nullable House find(int id);

    public List<House> all();

    public void insertHouse(@NotNull House house);

    public void updateHouse(@NotNull House house);

    public void deleteHouse(int id);

    public List<House> findByCompanyId(int id);
}
