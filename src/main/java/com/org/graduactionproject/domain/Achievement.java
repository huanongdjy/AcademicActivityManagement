package com.org.graduactionproject.domain;

import java.sql.Timestamp;
import java.util.List;

public class Achievement {
    private int id;
    private String title;
    private String author;
    private String member;
    private String content;
    private Timestamp acquisitiondate;
    private Timestamp time; // 发布时间
    private int ordering;
    private int read_num;
    private Boolean toshow;
    private int type_id;
    private List<Photo> photoList;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getAcquisitiondate() {
        return acquisitiondate;
    }

    public void setAcquisitiondate(Timestamp acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public int getRead_num() {
        return read_num;
    }

    public void setRead_num(int read_num) {
        this.read_num = read_num;
    }

    public Boolean getToshow() {
        return toshow;
    }

    public void setToshow(Boolean toshow) {
        this.toshow = toshow;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
