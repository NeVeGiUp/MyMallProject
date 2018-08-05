package com.lgh.havehui.allpackage.base;


//每个bean共有的字段,status,msg,data,如果请求的数据是一个集合那么不应该集成此basebean,另外创建一个base
public class BaseBean<T> {
    public String status;
    public String msg;
    public T      data;

    public String getStatus() {return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
