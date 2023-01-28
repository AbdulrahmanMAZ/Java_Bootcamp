package com.abdulrahman.assignment14.controller;

import com.abdulrahman.assignment14.module.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {
    ArrayList<Employee> emps = new ArrayList<>();

    @GetMapping("/emp")
    public ArrayList<Employee> getEmps() {
    return emps;
    }

    @PostMapping("/emp")
    public String addEmp(@Valid @RequestBody Employee emp) {
        emps.add(emp);
        return "Employee has been added";
    }
    @PutMapping("emp/{emp_id}")
    public String updateEmp(@PathVariable int emp_id,@Valid @RequestBody Employee emp) {
        emps.set(emp_id,emp);
        return "Employee has been updated";
    }
    @DeleteMapping("emp/{emp_id}")
    public String deleteEmp(@PathVariable int emp_id) {
        emps.remove(emp_id);
        return "Employee has been removed";
    }
    @PostMapping("/apply/{emp_id}")
    public ResponseEntity apply(@PathVariable int emp_id){

        Employee temp_emp = emps.get(emp_id);

        if (!temp_emp.isOnLeave() && temp_emp.getAnnualLeave() > 0 ){
            temp_emp.setOnLeave(true);
            temp_emp.setAnnualLeave(temp_emp.getAnnualLeave() - 1 );
            emps.set(emp_id,temp_emp);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

}
