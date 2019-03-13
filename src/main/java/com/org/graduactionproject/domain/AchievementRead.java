package com.org.graduactionproject.domain;

import java.sql.Timestamp;

public class AchievementRead {
    private int read_id;
    private int id;
    private String ip;
    private Timestamp time;

    public AchievementRead() {
    }

    public AchievementRead(int read_id, String ip, Timestamp time) {
        this.read_id = read_id;
        this.ip = ip;
        this.time = time;
    }

    public int getRead_id() {
        return read_id;
    }

    public void setRead_id(int read_id) {
        this.read_id = read_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
