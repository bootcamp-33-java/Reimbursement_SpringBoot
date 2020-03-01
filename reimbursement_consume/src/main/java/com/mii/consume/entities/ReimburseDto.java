package com.mii.consume.entities;

import lombok.Data;

@Data
public class ReimburseDto {
    private Ticket ticket;

    private String employeeId;
}
