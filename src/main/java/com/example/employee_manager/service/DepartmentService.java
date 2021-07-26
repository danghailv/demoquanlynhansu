package com.example.employee_manager.service;

import com.example.employee_manager.dto.DepartmentDisplayDTO;
import com.example.employee_manager.dto.DepartmentEnterDTO;
import com.example.employee_manager.dto.mapper.DepartmentMapper;
import com.example.employee_manager.entity.Department;
import com.example.employee_manager.entity.Employee;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public void addDepartment(DepartmentEnterDTO departmentEnterDTO){
        departmentRepository.save(DepartmentMapper.toDepartment(departmentEnterDTO));
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }



    public List<DepartmentDisplayDTO> findAllDepartment(){
        List<DepartmentDisplayDTO> departmentDisplayDTOS=new ArrayList<>();
        for (Department department:departmentRepository.findAll()
        ) {
            DepartmentDisplayDTO departmentDisplayDTO = DepartmentMapper.toEmployee(department);
            departmentDisplayDTOS.add(departmentDisplayDTO);

        }
        return departmentDisplayDTOS;
    }


    public void updateDepartment(DepartmentEnterDTO departmentEnterDTO, Long id) {
        Department department=departmentRepository.getById(id);
        Department newDepartment = DepartmentMapper.toDepartment(department,departmentEnterDTO);
        departmentRepository.save(newDepartment);

    }
}
