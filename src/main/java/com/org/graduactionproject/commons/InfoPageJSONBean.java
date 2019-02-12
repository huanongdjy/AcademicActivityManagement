package com.org.graduactionproject.commons;

import com.github.pagehelper.Page;

public class InfoPageJSONBean {
    private Page page;
    private String resultCode;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
