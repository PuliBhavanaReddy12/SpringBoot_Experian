package com.example.springbootcrudexample1.service;

import com.example.springbootcrudexample1.entity.Employee;
import com.example.springbootcrudexample1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository rep;

    //creating 200 random employee objects. using @postConstruct so that it is called once dependency inj is done.
    @PostConstruct
    public void initDB(){
        List<Employee> emps= IntStream.rangeClosed(1,200)
                .mapToObj(i->new Employee("employee"+i,new Random().nextInt(30)))
                .collect(Collectors.toList());
        rep.saveAll(emps);
    }
    //create
    public Employee saveEmployee(Employee emp){
        return rep.save(emp);
    }
    public List<Employee> saveEmployees(List<Employee> emps){
        return rep.saveAll(emps);
    }


    //retrieve
    public List<Employee> getEmployees(){
        return rep.findAll();
    }
    public Employee getEmployeeById(int id){
        return rep.findById(id).orElse(null);
    }
//    public Employee getEmployeeByName(String name){
//        return rep.findByName(name);
//    }

    //delete
    public String deleteEmployee(int id){
        rep.deleteById(id);
        return "Employee removed!"+id;
    }
    //update
    public Employee updateEmployee(Employee emp){
        Employee ex=rep.findById(emp.getId()).orElse(null);
        ex.setName(emp.getName());
        ex.setDeptNo(emp.getDeptNo());
        return rep.save(ex);
    }

    //paging
    public Page<Employee> findEmployeesWithPagination(int offset,int pageSize){
        Page<Employee> emps=rep.findAll(PageRequest.of(offset,pageSize));
        return emps;
    }

}
