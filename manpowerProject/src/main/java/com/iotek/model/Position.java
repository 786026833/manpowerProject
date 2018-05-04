package com.iotek.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Position implements Serializable {
    private Long pId;

    private String pName;

    private long pSalary;

    private Long dId;
    private Set<Employee> employees=new HashSet<>();

    public Position() {
    }

    public Position(Long pId) {
        this.pId = pId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public long getpSalary() {
        return pSalary;
    }

    public void setpSalary(long pSalary) {
        this.pSalary = pSalary;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pSalary=" + pSalary +
                ", dId=" + dId +
                ", employees=" + employees +
                '}';
    }
}