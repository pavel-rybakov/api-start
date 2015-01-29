package com.pavelrybakov.warehouse.services.impl;

import com.pavelrybakov.warehouse.dao.CompanyDao;
import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;
import com.pavelrybakov.warehouse.services.CompanyService;
import org.mybatis.guice.transactional.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import static com.pavelrybakov.warehouse.exceptions.WarehouseException.companyNotFound;

public class CompanyServiceImpl implements CompanyService {

    @Inject @NotNull CompanyDao companyDao;

    @Override
    @NotNull
    @Transactional
    public Company createCompany(String name) throws WarehouseException {
        Company company = new Company(name);

        companyDao.insertCompany(company);
        if (company.getId() == 0) {
            throw WarehouseException.companyNotSaved(name);
        }

        return getCompany(company.getId());
    }

    @Override
    @Nullable
    public Company findCompany(int id) {
        return companyDao.find(id);
    }

    @Override
    @NotNull
    public Company getCompany(int id) throws WarehouseException {
        Company company = companyDao.find(id);
        if (null == company) {
            throw companyNotFound(id);
        }

        return company;
    }

    @Override
    @Transactional
    public void deleteCompany(@NotNull Company company) {
        companyDao.deleteCompany(company.getId());
    }

    @Override
    @Transactional
    public void updateCompany(@NotNull Company company) {
        companyDao.updateCompany(company);
    }
}
