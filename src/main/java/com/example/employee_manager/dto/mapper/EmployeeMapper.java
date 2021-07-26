package com.example.employee_manager.dto.mapper;

import com.example.employee_manager.dto.EmployeeDTO;
import com.example.employee_manager.dto.EmployeeDisplay;
import com.example.employee_manager.entity.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmployeeMapper {
    public static Employee employee(EmployeeDTO employeeDTO){
        Employee employee= new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        try {
            employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(employeeDTO.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static Employee toEntity(Employee employee, EmployeeDTO employeeDTO) {
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        try {
            employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(employeeDTO.getDateOfBirth()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(employee.getDeparment().getId()!=employeeDTO.getIdDepartment()){
            employee.setStartWork(Calendar.getInstance().getTime());
        }


        return employee;
    }
    public static EmployeeDisplay toEmployee(Employee employee){
        EmployeeDisplay employeeDisplay=new EmployeeDisplay();
        employeeDisplay.setEmail(employee.getEmail());
        employeeDisplay.setStartWork(employee.getStartWork().toString());
        employeeDisplay.setDateOfBirth(employee.getDateOfBirth().toString());
        employeeDisplay.setFirstName(employee.getFirstName());
        employeeDisplay.setLastName(employee.getLastName());
        employeeDisplay.setNameDepartment(employee.getDeparment().getName());
        employeeDisplay.setId(employee.getId());
        return employeeDisplay;
    }
}
