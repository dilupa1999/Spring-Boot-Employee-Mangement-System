package com.example.employeeMS.service;

import com.example.employeeMS.dto.EmployDTO;
import com.example.employeeMS.entity.Employee;
import com.example.employeeMS.repo.EmployeeRepo;
import com.example.employeeMS.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static java.lang.Character.getType;

@Service
@Transactional

public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String saveEmployee(EmployDTO employeeDTO) {

        if (employeeRepo.existsById(employeeDTO.getEmpID())) {
            return VarList.RSP_No_Data_Found;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCeSS;
        }

    }


    public String updateEmployee(EmployDTO employeeDTO) {


        if (employeeRepo.existsById(employeeDTO.getEmpID())) {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCeSS;
        } else {
            return VarList.RSP_No_Data_Found;
        }

    }


    public List<EmployDTO> getAllEmployee() {
        List<Employee> employeeList = employeeRepo.findAll();

        return modelMapper.map(employeeList,new TypeToken<ArrayList<EmployDTO>>(){}.getType());
    }


    public EmployDTO searchEmployee(int empID) {


        if (employeeRepo.existsById(empID)) {
            Employee employee = employeeRepo.findById(empID).get();
            return modelMapper.map(employee, EmployDTO.class);
        } else {
          return null;
        }

    }

    public String deleteEmployee(int empID) {
        if (employeeRepo.existsById(empID)) {
            employeeRepo.deleteById(empID);
            return VarList.RSP_SUCCeSS;
        } else {
            return VarList.RSP_No_Data_Found;
        }
    }


}
