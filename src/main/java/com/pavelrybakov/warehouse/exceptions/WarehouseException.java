package com.pavelrybakov.warehouse.exceptions;

public class WarehouseException extends Exception {

    public final WarehouseErrorCode code;

    public WarehouseException(String message,WarehouseErrorCode code) {
        super(message);
        this.code = code;
    }

    public static WarehouseException companyNotFound(int id) {
        return new WarehouseException(String.format("Company %d not found", id), WarehouseErrorCode.NOT_FOUND);
    }

    public static WarehouseException companyNotSaved(String name) {
        return new WarehouseException(String.format("Cannot create company %s", name), WarehouseErrorCode.CREATE_ERROR);
    }
}
