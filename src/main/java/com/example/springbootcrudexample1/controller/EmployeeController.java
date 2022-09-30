package com.example.springbootcrudexample1.controller;

import com.example.springbootcrudexample1.entity.Employee;
import com.example.springbootcrudexample1.jpa.dto.APIResponse;
import com.example.springbootcrudexample1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService ser;

    //create
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee emp){
        return ser.saveEmployee(emp);
    }
    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> emps){
        return ser.saveEmployees(emps);
    }

    //retieve
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return ser.getEmployees();
    }
    @GetMapping("/")
    public APIResponse<List<Employee>> getEmployees(){
        List<Employee> allEmps=ser.getEmployees();
        return new APIResponse<>(allEmps.size(),allEmps);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<Employee>> getEmployeesWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        Page<Employee> empsWithPagination=ser.findEmployeesWithPagination(offset, pageSize);
        return new APIResponse<>(empsWithPagination.getSize(),empsWithPagination);
    }

    @GetMapping("/employeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        return ser.getEmployeeById(id);
    }
//    @GetMapping("/getName/name/{name}")
//    public Employee findEmployeeByName(@PathVariable String name){
//        return ser.getEmployeeByName(name);
//    }

    //update
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee emp){
        return ser.updateEmployee(emp);
    }


    //delete
    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return ser.deleteEmployee(id);
    }


}
