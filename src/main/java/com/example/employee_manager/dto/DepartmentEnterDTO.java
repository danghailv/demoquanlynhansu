package com.example.employee_manager.dto;

public class DepartmentEnterDTO {
    private String name;
    private byte departmentalFloor;

    public DepartmentEnterDTO(String name, byte departmentalFloor) {
        this.name = name;
        this.departmentalFloor = departmentalFloor;
    }

    public DepartmentEnterDTO() {
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

    @Override
    public String toString() {
        return "DepartmentEnterDTO{" +
                "name='" + name + '\'' +
                ", departmentalFloor=" + departmentalFloor +
                '}';
    }

}
