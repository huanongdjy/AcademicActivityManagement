package com.org.graduactionproject.domain;

import java.sql.Timestamp;

public class Essay {
    private int id;
    private String title;
    private String theme;
    private String summary;
    private Timestamp time;
    private String location;
    private String content;
    private String precautions;//注意事项
    private String fund;//资金
    private String oranizer;//组织者
    private int planned_attendance;//计划出席
    private int actual_attendance;//实际出席
    private byte[] photo;//照片
    private String outcome;//结论、总结
    private int index;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
