package com.example.employee_manager.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deparment")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "departmentalFloor")
    private byte departmentalFloor;

    @OneToMany(mappedBy =  "deparment",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<Employee> employeeList;


    public Long getId() {
        return id;
    }

    public Department( String name, byte departmentalFloor, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.departmentalFloor = departmentalFloor;
        this.employeeList = employeeList;
    }

    public Department(Long id, String name, byte departmentalFloor, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.departmentalFloor = departmentalFloor;
        this.employeeList = employeeList;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getDepartmentalFloor() {
        return departmentalFloor;
    }

    public void setDepartmentalFloor(byte departmentalFloor) {
        this.departmentalFloor = departmentalFloor;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
