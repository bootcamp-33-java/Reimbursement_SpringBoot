/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.entities;

import lombok.Data;

import java.util.List;

/**
 * @author Insane
 */

@Data
public class EmployeeAPI {
    private List<String> roles;

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String birthDate;

    private String birthPlace;

    private String gender;

    private String isDelete;

    private String department;

    private String nationality;

    private EmployeeAPI manager;

   }