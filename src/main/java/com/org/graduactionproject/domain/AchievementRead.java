package com.org.graduactionproject.domain;

import java.sql.Timestamp;

public class AchievementRead {
    private int read_id;
    private int id;
    private Timestamp read_time;

    public AchievementRead() {
    }

    public AchievementRead(int read_id, Timestamp read_time) {
        this.read_id = read_id;
        this.read_time = read_time;
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

    public Timestamp getRead_time() {
        return read_time;
    }

    public void setRead_time(Timestamp read_time) {
        this.read_time = read_time;
    }
}
