package com.iotek.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/21.
 */
public class RecruitmentInformation implements Serializable {
    private Long recId;

    private String recTitle;

    private String recContent;

    private Date recTime;

    public RecruitmentInformation() {
    }

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getRecTitle() {
        return recTitle;
    }

    public void setRecTitle(String recTitle) {
        this.recTitle = recTitle == null ? null : recTitle.trim();
    }

    public String getRecContent() {
        return recContent;
    }

    public void setRecContent(String recContent) {
        this.recContent = recContent == null ? null : recContent.trim();
    }

    public Date getRecTime() {
        return recTime;
    }

    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

}
