package com.org.graduactionproject.commons;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public class InfoPageJSONBean {
    private PageInfo page;
    private String resultCode;

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
