package com.iotek.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable{
    private Long dId;
    private String dName;
    private Date dTime;
    private Set<Position> positions=new HashSet<>();
    private Set<Employee> employees=new HashSet<>();
    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dTime=" + dTime +
                ", positions=" + positions +
                '}';
    }
}