package com.org.graduactionproject.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Achievement {
    private int achievement_id;
    private String achievement_name;
    private String member;
    private String content;
    private Timestamp acquisitiondate;
    private Timestamp pubdate;

    public int getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(int achievement_id) {
        this.achievement_id = achievement_id;
    }

    public String getAchievement_name() {
        return achievement_name;
    }

    public void setAchievement_name(String achievement_name) {
        this.achievement_name = achievement_name;
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

    public Timestamp getPubdate() {
        return pubdate;
    }

    public void setPubdate(Timestamp pubdate) {
        this.pubdate = pubdate;
    }
}
