package com.marko.mongodb.dtos;

import com.marko.mongodb.Address;
import com.marko.mongodb.Gender;

import java.math.BigDecimal;
import java.util.List;

public record AddStudentDTO(
        String firstname,
        String lastname,
        String email,
        Gender gender,
        List<String> favSubs,
        Address address,
        BigDecimal totalSpentInBooks) {

}


