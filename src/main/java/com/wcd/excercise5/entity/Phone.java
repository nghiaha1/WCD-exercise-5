package com.wcd.excercise5.entity;

import com.wcd.excercise5.entity.base.BaseEntity;
import com.wcd.excercise5.entity.myenum.PhoneStatus;

import java.util.HashMap;

public class Phone extends BaseEntity {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private PhoneStatus status;
    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate(){
        if (name == null || name.length() == 0 || name.length() <= 7) {
            errors.put("name", "Please enter name");
        }
        if (brand == null || brand.length() == 0) {
            errors.put("brand", "Please enter brand");
        }
        if (price <= 0) {
            errors.put("price", "Please choose price");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public Phone() {
        this.name = "";
        this.brand = "";
        this.description = "";
        this.price = 0;
        this.status = PhoneStatus.ACTIVE;
    }

    public Phone(int id, String name, String brand, double price, String description, PhoneStatus status) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhoneStatus getStatus() {
        return status;
    }

    public void setStatus(PhoneStatus status) {
        this.status = status;
    }
}
