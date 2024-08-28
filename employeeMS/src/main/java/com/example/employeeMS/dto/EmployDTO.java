package com.example.employeeMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployDTO {

    private  int empID;
    private String empName;
    private String empAddress;
    private String empMobile;
}