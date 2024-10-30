package com.example.salesbackend.Repository;


import com.example.salesbackend.Model.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(long id);
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
}
