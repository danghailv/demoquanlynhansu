package com.example.employee_manager.controller;


import com.example.employee_manager.dto.EmployeeDTO;
import com.example.employee_manager.dto.EmployeeDisplay;
import com.example.employee_manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class        EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public ResponseEntity<List<EmployeeDisplay>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam( name = "name",required = false ,defaultValue = "") String name){
        List<EmployeeDisplay> employees= employeeService.searchEmployee(name);
        return  ResponseEntity.ok(employees);
    }
    @PostMapping()
    public ResponseEntity<String> registerNewDepartment(@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
        return  ResponseEntity.ok("Thêm nhân viên thành công");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id){
            employeeService.updateEmployee(employeeDTO,id);
            return ResponseEntity.ok("Cập nhập thành công nhân viên có id:"+id);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("xóa thành công");
    }


}
