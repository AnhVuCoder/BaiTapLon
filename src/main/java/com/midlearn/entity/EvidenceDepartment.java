package com.midlearn.entity;

import java.time.LocalDate;

public class EvidenceDepartment {
    private Department department;
    private LocalDate supplyDate;
    public EvidenceDepartment(){}
    public EvidenceDepartment(Department department, LocalDate supplyDate) {
        this.department = department;
        this.supplyDate = supplyDate;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDate supplyDate) {
        this.supplyDate = supplyDate;
    }
}
