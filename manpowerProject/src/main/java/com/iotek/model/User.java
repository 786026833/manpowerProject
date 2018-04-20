package com.iotek.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Long uId;

    private String uName;

    private String uPass;

    public User() {
    }

    public User(String uName, String uPass) {
        this.uName = uName;
        this.uPass = uPass;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass == null ? null : uPass.trim();
    }


}