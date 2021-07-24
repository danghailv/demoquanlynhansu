package com.example.employee_manager.dto.mapper;

import com.example.employee_manager.dto.DepartmentDisplayDTO;
import com.example.employee_manager.dto.DepartmentEnterDTO;
import com.example.employee_manager.entity.Department;

import java.util.ArrayList;

public class DepartmentMapper {

    public static Department toDepartment(DepartmentEnterDTO departmentEnterDTO){
        Department department = new Department();
        department.setName(departmentEnterDTO.getName());
        department.setDepartmentalFloor(departmentEnterDTO.getDepartmentalFloor());
        department.setEmployeeList(new ArrayList<>());
        return department;
    }

    public static DepartmentDisplayDTO toEmployee(Department department) {
        DepartmentDisplayDTO departmentDisplayDTO=new DepartmentDisplayDTO();
        departmentDisplayDTO.setId(department.getId());
        departmentDisplayDTO.setDepartmentalFloor(department.getDepartmentalFloor());
        departmentDisplayDTO.setName(department.getName());
        departmentDisplayDTO.setNumberEmployee((byte) department.getEmployeeList().size());
        return departmentDisplayDTO;
    }

    public static Department toDepartment(Department department, DepartmentEnterDTO departmentEnterDTO) {
        department.setName(departmentEnterDTO.getName());
        department.setDepartmentalFloor(departmentEnterDTO.getDepartmentalFloor());
        return department;
    }
}
