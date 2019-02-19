package com.org.graduactionproject.domain;

public class Identity {
    private Integer identity_id;
    private String access;
    private String identity_name;

    public Integer getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(Integer identity_id) {
        this.identity_id = identity_id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getIdentity_name() {
        return identity_name;
    }

    public void setIdentity_name(String identity_name) {
        this.identity_name = identity_name;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "identity=" + identity_id +
                ", access='" + access + '\'' +
                ", identity_name='" + identity_name + '\'' +
                '}';
    }
}
