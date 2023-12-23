package com.midlearn.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evidence extends CommonEntity<String> {
    private static int count;
    {
        this.id=String.format("EV%06d",++count);
    }
    private String name;
    private String promulgatePlace;
    private LocalDate promulgateDate;
    private LocalDate publicDate;
    private LocalDate createDate;
    private List<Department> departmentList=new ArrayList<>();
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromulgatePlace() {
        return promulgatePlace;
    }

    public void setPromulgatePlace(String promulgatePlace) {
        this.promulgatePlace = promulgatePlace;
    }

    public LocalDate getPromulgateDate() {
        return promulgateDate;
    }

    public void setPromulgateDate(LocalDate promulgateDate) {
        this.promulgateDate = promulgateDate;
    }

    public LocalDate getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(LocalDate publicDate) {
        this.publicDate = publicDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
