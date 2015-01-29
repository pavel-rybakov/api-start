package com.pavelrybakov.warehouse.dao;

import com.pavelrybakov.warehouse.domains.Company;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import java.util.List;

public interface CompanyDao {

    @Nullable Company find(int id);

    public List<Company> all();

    public void insertCompany(@NotNull Company company);

    public void updateCompany(@NotNull Company company);

    public void deleteCompany(int id);
}
