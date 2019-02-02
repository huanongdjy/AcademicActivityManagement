package com.org.graduactionproject.domain;

import java.util.Date;

public class Essay {
    private int essay_id;
    private String theme;
    private String summary;
    private Date essay_time;
    private String location;
    private String content;
    private String precautions;
    private String fund;
    private String oranizer;
    private int planned_attendance;
    private int actual_attendance;
    private byte[] photo;
    private String outcome;

    public int getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(int essay_id) {
        this.essay_id = essay_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getEssay_time() {
        return essay_time;
    }

    public void setEssay_time(Date essay_time) {
        this.essay_time = essay_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getOranizer() {
        return oranizer;
    }

    public void setOranizer(String oranizer) {
        this.oranizer = oranizer;
    }

    public int getPlanned_attendance() {
        return planned_attendance;
    }

    public void setPlanned_attendance(int planned_attendance) {
        this.planned_attendance = planned_attendance;
    }

    public int getActual_attendance() {
        return actual_attendance;
    }

    public void setActual_attendance(int actual_attendance) {
        this.actual_attendance = actual_attendance;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
