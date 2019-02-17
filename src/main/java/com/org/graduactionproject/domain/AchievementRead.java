package com.org.graduactionproject.domain;

public class AchievementRead {
    private int read_id;
    private int id;
    private String ip;

    public AchievementRead() {
    }

    public AchievementRead(int id, String ip) {
        this.id = id;
        this.ip = ip;
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
