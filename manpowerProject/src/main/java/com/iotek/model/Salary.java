package com.iotek.model;

import java.math.BigDecimal;

public class Salary {
    private Long sId;

    private BigDecimal sBaseSal;

    private BigDecimal sPerfSal;

    private Long sOverSal;

    private Long sPenaltySal;

    private Long sSocSal;

    private BigDecimal sTotalSal;

    private Long eId;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public BigDecimal getsBaseSal() {
        return sBaseSal;
    }

    public void setsBaseSal(BigDecimal sBaseSal) {
        this.sBaseSal = sBaseSal;
    }

    public BigDecimal getsPerfSal() {
        return sPerfSal;
    }

    public void setsPerfSal(BigDecimal sPerfSal) {
        this.sPerfSal = sPerfSal;
    }

    public Long getsOverSal() {
        return sOverSal;
    }

    public void setsOverSal(Long sOverSal) {
        this.sOverSal = sOverSal;
    }

    public Long getsPenaltySal() {
        return sPenaltySal;
    }

    public void setsPenaltySal(Long sPenaltySal) {
        this.sPenaltySal = sPenaltySal;
    }

    public Long getsSocSal() {
        return sSocSal;
    }

    public void setsSocSal(Long sSocSal) {
        this.sSocSal = sSocSal;
    }

    public BigDecimal getsTotalSal() {
        return sTotalSal;
    }

    public void setsTotalSal(BigDecimal sTotalSal) {
        this.sTotalSal = sTotalSal;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }
}