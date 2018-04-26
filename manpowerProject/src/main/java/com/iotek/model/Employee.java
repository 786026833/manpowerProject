package com.iotek.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Employee implements Serializable {
    private Long eId;

    private String eName;

    private String ePass;

    private String ePhone;

    private String eSex;

    private Short eAge;
    private String eState;
    private Long eDid;
    private Long ePid;
    private Date eJoinDate;
    private Long eTrain;
    public Long geteId() {
        return eId;
    }

    public long geteTrain() {
        return eTrain;
    }

    public Long geteDid() {
        return eDid;
    }

    public void seteDid(Long eDid) {
        this.eDid = eDid;
    }

    public void seteTrain(long eTrain) {
        this.eTrain = eTrain;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getePass() {
        return ePass;
    }

    public void setePass(String ePass) {
        this.ePass = ePass == null ? null : ePass.trim();
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone == null ? null : ePhone.trim();
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    public Short geteAge() {
        return eAge;
    }

    public void seteAge(Short eAge) {
        this.eAge = eAge;
    }

    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState == null ? null : eState.trim();
    }

    public long getePid() {
        return ePid;
    }

    public void setePid(long ePid) {
        this.ePid = ePid;
    }

    public Date geteJoinDate() {
        return eJoinDate;
    }

    public void seteJoinDate(Date eJoinDate) {
        this.eJoinDate = eJoinDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", ePass='" + ePass + '\'' +
                ", ePhone='" + ePhone + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eAge=" + eAge +
                ", eState='" + eState + '\'' +
                ", eTrain='" + eTrain + '\'' +
                ", ePid=" + ePid +
                ", eJoinDate=" + eJoinDate +
                '}';
    }
}
