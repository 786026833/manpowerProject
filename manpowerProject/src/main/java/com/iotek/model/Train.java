package com.iotek.model;

public class Train {
    private Long tId;

    private String tTitle;

    private String tContent;

    private String tBeginTime;

    private String tTrainee;

    private String tEndTime;

    private String tSite;

    private Long trId;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle == null ? null : tTitle.trim();
    }

    public String gettContent() {
        return tContent;
    }

    public void settContent(String tContent) {
        this.tContent = tContent == null ? null : tContent.trim();
    }

    public String gettBeginTime() {
        return tBeginTime;
    }

    public void settBeginTime(String tBeginTime) {
        this.tBeginTime = tBeginTime == null ? null : tBeginTime.trim();
    }

    public String gettTrainee() {
        return tTrainee;
    }

    public void settTrainee(String tTrainee) {
        this.tTrainee = tTrainee == null ? null : tTrainee.trim();
    }

    public String gettEndTime() {
        return tEndTime;
    }

    public void settEndTime(String tEndTime) {
        this.tEndTime = tEndTime == null ? null : tEndTime.trim();
    }

    public String gettSite() {
        return tSite;
    }

    public void settSite(String tSite) {
        this.tSite = tSite == null ? null : tSite.trim();
    }

    public Long getTrId() {
        return trId;
    }

    public void setTrId(Long trId) {
        this.trId = trId;
    }
}