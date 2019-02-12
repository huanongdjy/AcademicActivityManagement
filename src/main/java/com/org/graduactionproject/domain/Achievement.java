package com.org.graduactionproject.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Achievement {
    private int id;
    private String title;
    private String member;
    private String content;
    private Timestamp acquisitiondate;
    private Timestamp time;
    private int index;
    private String read;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
