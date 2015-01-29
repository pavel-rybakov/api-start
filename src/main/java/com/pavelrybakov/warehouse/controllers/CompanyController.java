package com.pavelrybakov.warehouse.controllers;


import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.domains.House;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
public class CompanyController extends BaseController {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getDefault() {
        return Response.status(200).entity("Company api").build();
    }

    @GET
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    public Company createCompany(@QueryParam("name") @NotNull String name) {
        Company company;
        try {
            company = companyService.createCompany(name);
        } catch (WarehouseException e) {
            throw new WebApplicationException(e.getMessage(), Response.status(500).build());
        }

        return company;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Company getCompany(@PathParam("id") int id) {
        Company company = companyService.findCompany(id);
        if (null == company) {
            throw new WebApplicationException(String.format("Company %d not found", id), Response.status(404).build());
        }

        return company;
    }

    @GET
    @Path("/{id}/update")
    @Produces({MediaType.APPLICATION_JSON})
    public Company updateCompany(@PathParam("id") int id, @QueryParam("name") String name) {
        Company company = companyService.findCompany(id);
        if (null == company) {
            throw new WebApplicationException(String.format("Company %d not found", id), Response.status(404).build());
        }
        company.setName(name);
        companyService.updateCompany(company);

        return company;
    }

    @GET
    @Path("/{id}/delete")
    @Produces({MediaType.TEXT_PLAIN})
    public Response deleteCompany(@PathParam("id") int id) {
        Company company = companyService.findCompany(id);
        if (null == company) {
            throw new WebApplicationException(String.format("Company %d not found", id), Response.status(404).build());
        }
        companyService.deleteCompany(company);

        return Response.status(200).entity("deleted").build();
    }

}