package com.pillowlux.model;

import java.time.LocalDate;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "customer", schema = "project0")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "first_name", nullable = false, updatable = false)
    @Length(min = 1)
    @NotBlank
    private String fName;


    @Column(name = "last_name", nullable = false, updatable = false)
    @Length(min = 1)
    @NotBlank
    private String lName;


    @Column(nullable = false)
    @Length(min = 1)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @Length(min = 1)
    @NotBlank
    private String password;


    @Column(name = "date_of_birth", nullable = false)
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String dob;


    @Column(nullable = false)
    private String address;


    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

}
	