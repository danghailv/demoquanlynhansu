package com.example.employee_manager.controller;


import com.example.employee_manager.dto.DepartmentDisplayDTO;
import com.example.employee_manager.dto.DepartmentEnterDTO;
import com.example.employee_manager.dto.EmployeeDTO;
import com.example.employee_manager.dto.EmployeeDisplay;
import com.example.employee_manager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping()
    public ResponseEntity<List<DepartmentDisplayDTO>> getAllEmployee(){
        return ResponseEntity.ok(departmentService.findAllDepartment());
    }

    @PostMapping()
    public ResponseEntity<String> registerNewDepartment(@RequestBody DepartmentEnterDTO departmentEnterDTO){
        departmentService.addDepartment(departmentEnterDTO);
        return  ResponseEntity.ok("Thêm phòng ban thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("xóa thành công");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@RequestBody DepartmentEnterDTO departmentEnterDTO, @PathVariable Long id){
        departmentService.updateDepartment(departmentEnterDTO,id);
        return ResponseEntity.ok("Cập nhập thành công phòng ban có id:"+id);

    }

}
