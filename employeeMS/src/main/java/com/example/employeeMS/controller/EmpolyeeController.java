package com.example.employeeMS.controller;

import com.example.employeeMS.dto.EmployDTO;
import com.example.employeeMS.dto.ResponseDTO;
import com.example.employeeMS.service.EmployeeService;
import com.example.employeeMS.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1//employee")
public class EmpolyeeController {


    @Autowired
    private  EmployeeService employeeService;
@Autowired
private ResponseDTO responseDTO;

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployDTO employeeDTO) {
        try {
            String res=employeeService.saveEmployee(employeeDTO);


            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCeSS);
                responseDTO.setMessage("Sucessfully Saved");
                responseDTO.setContent(employeeDTO);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_No_Data_Found);
                responseDTO.setMessage("Sucessfully Saved");
                responseDTO.setContent(employeeDTO);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
////ggg

                return null;
            }


        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




@PutMapping (value = "/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployDTO employeeDTO) {


        try {
            String res =employeeService.updateEmployee(employeeDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCeSS);
                responseDTO.setMessage("Sucessfully Saved");
                responseDTO.setContent(employeeDTO);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_No_Data_Found);
                responseDTO.setMessage("not a register employee");
                responseDTO.setContent(employeeDTO);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
////ggg

                return null;
            }



        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;


    }



    @GetMapping (value = "/getAllEmployee")
    public ResponseEntity getAllEmployee() {
        try {
            List<EmployDTO> employDTOList = employeeService.getAllEmployee();
            responseDTO.setCode(VarList.RSP_SUCCeSS);
            responseDTO.setMessage("Sucessfully Saved");
            responseDTO.setContent(employDTOList);

            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @GetMapping (value = "/searchEmployee/{empID}")
    public ResponseEntity searchEmployee(@PathVariable int empID) {
        try {
            EmployDTO employDTO = employeeService.searchEmployee(empID);
            responseDTO.setCode(VarList.RSP_SUCCeSS);
            responseDTO.setMessage("Sucessfully Saved");
            responseDTO.setContent(employDTO);

            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @DeleteMapping  (value = "/deleteEmployee/{empID}")
    public ResponseEntity deleteEmployee(@PathVariable int empID) {
        try {
            String res = employeeService.deleteEmployee(empID);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCeSS);
                responseDTO.setMessage("Sucessfully Saved");
                responseDTO.setContent(null);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_No_Data_Found);
                responseDTO.setMessage("not a register employee");
                responseDTO.setContent(null);

                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {


                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
}
