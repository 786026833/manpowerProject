package com.iotek.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Position implements Serializable {
    private Long pId;

    private String pName;

    private BigDecimal pSalary;

    private Long dId;

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

    public BigDecimal getpSalary() {
        return pSalary;
    }

    public void setpSalary(BigDecimal pSalary) {
        this.pSalary = pSalary;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }
}