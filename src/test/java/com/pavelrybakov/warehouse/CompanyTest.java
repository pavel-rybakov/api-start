package com.pavelrybakov.warehouse;

import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;
import com.pavelrybakov.warehouse.services.CompanyService;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CompanyTest extends BaseTest {

    @Inject CompanyService companyService;

    @Test
    public void testGetCompany() {
        Company company;
        try {
            company = companyService.createCompany("test");
        } catch (WarehouseException e) {
            e.printStackTrace();
            return;
        }

        int companyId = company.getId();
        assertEquals(company.getName(), "test");

        companyService.deleteCompany(company);

        Company empty = companyService.findCompany(companyId);
        assertNull(empty);
    }
}