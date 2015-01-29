package com.pavelrybakov.warehouse.exceptions;

public enum WarehouseErrorCode {

    NOT_FOUND(1),
    CREATE_ERROR(2);

    public final int code;

    WarehouseErrorCode(int code) {
        this.code = code;
    }

}
