package com.example.employeeManagementSystem.controller;

import com.example.employeeManagementSystem.dto.EmployeeDTO;
import com.example.employeeManagementSystem.dto.ResponseDTO;
import com.example.employeeManagementSystem.service.EmployeeService;
import com.example.employeeManagementSystem.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping(value = "/saveEmp")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try{
            String res = employeeService.saveEmployee(employeeDTO);
            if (res.equals("80")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("SUCCESS");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("86")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("DUPLICATED");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("FAILED");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage("SERVER ERROR");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);


    }


    }
}
