package com.pavelrybakov.warehouse.domains;

public class House {

    private int id;
    private int companyId;
    private String name;

    public House() {
    }

    public House(Company company, String name) {
        this.companyId = company.getId();
        this.name = name;
    }

    public House(int id, int companyId, String name) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
