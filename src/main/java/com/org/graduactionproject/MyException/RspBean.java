package com.org.graduactionproject.MyException;

import java.io.Serializable;
import java.util.HashMap;

public class RspBean extends HashMap<String, Object> {
    public RspBean fail(Object message) {
        this.put("resultCode",400);
//        this.put("message", message);
        this.put("message", "系统内部发生错误，请联系管理员");
        return this;
    }
}
