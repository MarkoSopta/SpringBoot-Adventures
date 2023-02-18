package com.marko.mongodb;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favSubs;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;


    //  no id constructor
    public Student(String firstname,
                   String lastname,
                   String email,
                   Gender gender,
                   Address address,
                   List<String> favSubs,
                   BigDecimal totalSpentInBooks,
                   LocalDateTime created) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favSubs = favSubs;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
