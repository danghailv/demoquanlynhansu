package com.example.employee_manager.service;

import com.example.employee_manager.dto.EmployeeDTO;
import com.example.employee_manager.dto.EmployeeDisplay;
import com.example.employee_manager.dto.mapper.EmployeeMapper;
import com.example.employee_manager.entity.Department;
import com.example.employee_manager.entity.Employee;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public void addEmployee(EmployeeDTO employeeDTO){
        Department department = departmentRepository.getById(employeeDTO.getIdDepartment());
        department.toString();
        Employee employee =  EmployeeMapper.employee(employeeDTO);
        employee.setDeparment(department);
            employee.setStartWork(Calendar.getInstance().getTime());
            employeeRepository.save(employee);

    }

    public List<EmployeeDisplay> findAllEmployee(){
        List<EmployeeDisplay> employeeDisplays=new ArrayList<>();
        for (Employee employee:employeeRepository.findAll()
             ) {
            EmployeeDisplay employeeDisplay = EmployeeMapper.toEmployee(employee);
            employeeDisplays.add(employeeDisplay);

        }
        return employeeDisplays;
    }

    public List<EmployeeDisplay> searchEmployee(String keyword) {
        List<EmployeeDisplay> result = new ArrayList<>();
        for(Employee employee :employeeRepository.findAll()){
            if(employee.getFirstName().contains(keyword)){

                result.add(EmployeeMapper.toEmployee(employee));
            }
        }
        return result;
    }

    public void updateEmployee(EmployeeDTO  employeeDTO ,Long id){
        Department department=departmentRepository.getById(employeeDTO.getIdDepartment());
        Employee employee= employeeRepository.getById((id));
        Employee newEmployee =EmployeeMapper.toEntity(employee,employeeDTO);
        newEmployee.setDeparment(department);
        employeeRepository.save(newEmployee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
