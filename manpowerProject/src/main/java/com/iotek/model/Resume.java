package com.iotek.model;

import java.io.Serializable;

public class Resume implements Serializable{
    private Long rId;

    private String rName;

    private String rSex;

    private String rPhone;

    private String rAge;

    private String rEducation;

    private String rWorkExperience;

    private String rCareerObjective;

    private User user;

    public Resume(Long rId) {
        this.rId = rId;
    }

    public Resume() {
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrSex() {
        return rSex;
    }

    public void setrSex(String rSex) {
        this.rSex = rSex == null ? null : rSex.trim();
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone == null ? null : rPhone.trim();
    }

    public String getrAge() {
        return rAge;
    }

    public void setrAge(String rAge) {
        this.rAge = rAge == null ? null : rAge.trim();
    }

    public String getrEducation() {
        return rEducation;
    }

    public void setrEducation(String rEducation) {
        this.rEducation = rEducation == null ? null : rEducation.trim();
    }

    public String getrWorkExperience() {
        return rWorkExperience;
    }

    public void setrWorkExperience(String rWorkExperience) {
        this.rWorkExperience = rWorkExperience == null ? null : rWorkExperience.trim();
    }

    public String getrCareerObjective() {
        return rCareerObjective;
    }

    public void setrCareerObjective(String rCareerObjective) {
        this.rCareerObjective = rCareerObjective == null ? null : rCareerObjective.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", rSex='" + rSex + '\'' +
                ", rPhone='" + rPhone + '\'' +
                ", rAge='" + rAge + '\'' +
                ", rEducation='" + rEducation + '\'' +
                ", rWorkExperience='" + rWorkExperience + '\'' +
                ", rCareerObjective='" + rCareerObjective + '\'' +
                '}';
    }
}