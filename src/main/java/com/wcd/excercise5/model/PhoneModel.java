package com.wcd.excercise5.model;

import com.wcd.excercise5.entity.Phone;

import java.util.List;

public interface PhoneModel {
    Phone add(Phone obj);

    List<Phone> findAll();

}
