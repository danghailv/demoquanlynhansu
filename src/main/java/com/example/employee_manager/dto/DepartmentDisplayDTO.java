package com.example.employee_manager.dto;

public class DepartmentDisplayDTO {
    private Long id;
    private String name;
    private byte departmentalFloor;
    private byte numberEmployee;

    public DepartmentDisplayDTO() {
    }

    public DepartmentDisplayDTO(Long id, String name, byte departmentalFloor, byte numberEmployee) {
        this.id = id;
        this.name = name;
        this.departmentalFloor = departmentalFloor;
        this.numberEmployee = numberEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public byte getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(byte numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    @Override
    public String toString() {
        return "DepartmentDisplayDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentalFloor=" + departmentalFloor +
                ", numberEmployee=" + numberEmployee +
                '}';
    }
}
