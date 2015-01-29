package com.pavelrybakov.warehouse.controllers;

import com.pavelrybakov.warehouse.domains.Company;
import com.pavelrybakov.warehouse.domains.House;
import com.pavelrybakov.warehouse.exceptions.WarehouseException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/house")
public class HouseController extends BaseController {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getDefault() {
        return Response.status(200).entity("House api").build();
    }

    @GET
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    public House addHouse(
            @QueryParam("companyId") int companyId,
            @QueryParam("name") String name) {
        Company company = companyService.findCompany(companyId);
        if (null == company) {
            throw new WebApplicationException(String.format("Company %d not found", companyId), Response.status(404).build());
        }

        House house = houseService.createHouse(company, name);
        if (null == house) {
            throw new WebApplicationException(String.format("Create house for company %d error", companyId), Response.status(404).build());
        }

        return house;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public House getHouse(@PathParam("id") int houseId) {
        House house = houseService.findHouse(houseId);
        if (null == house) {
            throw new WebApplicationException(String.format("House %d not found", houseId), Response.status(404).build());
        }

        return house;
    }

    @GET
    @Path("/{id}/update")
    @Produces({MediaType.APPLICATION_JSON})
    public House updateHouse(
            @PathParam("id") int houseId,
            @QueryParam("name") String name) {
        House house;
        try {
            house = houseService.getHouse(houseId);
        } catch (WarehouseException e) {
            throw new WebApplicationException(e.getMessage(), Response.status(404).build());
        }
        house.setName(name);
        houseService.updateHouse(house);

        return house;
    }

    @GET
    @Path("/{id}/delete")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteHouse(
            @PathParam("id") int houseId) {
        House house;
        try {
            house = houseService.getHouse(houseId);
        } catch (WarehouseException e) {
            throw new WebApplicationException(e.getMessage(), Response.status(404).build());
        }

        houseService.deleteHouse(house);
        return Response.status(200).entity("deleted").build();
    }


}