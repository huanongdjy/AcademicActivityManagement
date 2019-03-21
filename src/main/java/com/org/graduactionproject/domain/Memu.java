package com.org.graduactionproject.domain;

public class Memu {
    private int memu_id;
    private String memu_name;
    private String access;

    public int getMemu_id() {
        return memu_id;
    }

    public void setMemu_id(int memu_id) {
        this.memu_id = memu_id;
    }

    public String getMemu_name() {
        return memu_name;
    }

    public void setMemu_name(String memu_name) {
        this.memu_name = memu_name;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
