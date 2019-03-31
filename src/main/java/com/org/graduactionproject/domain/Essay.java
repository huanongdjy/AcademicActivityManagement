package com.org.graduactionproject.domain;

import java.sql.Timestamp;
import java.util.List;

public class Essay {
    private int id;
    private String title;
//    private String theme;
    private String summary;
    private String author;
    private Timestamp time;
    private Timestamp hold_time;
    private String location;
    private String content;
    private String precautions;//注意事项
    private String fund;//资金
    private String organizer;//组织者
    private int planned_attendance;//计划出席
    private int actual_attendance;//实际出席
//    private String outcome;//结论、总结
    private int ordering;
    private int type_id;
    private int read_num;
    private boolean toshow;
    private List<Photo> photoList;
    private Integer college_id;

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

//    public String getTheme() {
//        return theme;
//    }
//
//    public void setTheme(String theme) {
//        this.theme = theme;
//    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getHold_time() {
        return hold_time;
    }

    public void setHold_time(Timestamp hold_time) {
        this.hold_time = hold_time;
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

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
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

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getRead_num() {
        return read_num;
    }

    public void setRead_num(int read_num) {
        this.read_num = read_num;
    }

    public boolean isToshow() {
        return toshow;
    }

    public void setToshow(boolean toshow) {
        this.toshow = toshow;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public Integer getCollege_id() {
        return college_id;
    }

    public void setCollege_id(Integer college_id) {
        this.college_id = college_id;
    }
}
