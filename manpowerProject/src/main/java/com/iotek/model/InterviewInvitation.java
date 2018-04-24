package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

public class InterviewInvitation implements Serializable {
    private Short iId;

    private String iInterviewTime;

    private String iInterviewSite;

    private Long uId;
    private Long rId;
    private Long iState;
    public Short getiId() {
        return iId;
    }

    public void setiId(Short iId) {
        this.iId = iId;
    }

    public String getiInterviewTime() {
        return iInterviewTime;
    }

    public void setiInterviewTime(String iInterviewTime) {
        this.iInterviewTime = iInterviewTime;
    }

    public String getiInterviewSite() {
        return iInterviewSite;
    }

    public void setiInterviewSite(String iInterviewSite) {
        this.iInterviewSite = iInterviewSite == null ? null : iInterviewSite.trim();
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getiState() {
        return iState;
    }

    public void setiState(Long iState) {
        this.iState = iState;
    }

    @Override
    public String toString() {
        return "InterviewInvitation{" +
                "iId=" + iId +
                ", iInterviewTime='" + iInterviewTime + '\'' +
                ", iInterviewSite='" + iInterviewSite + '\'' +
                ", uId=" + uId +
                ", rId=" + rId +
                ", iState=" + iState +
                '}';
    }
}