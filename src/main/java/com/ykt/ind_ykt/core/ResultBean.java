package com.ykt.ind_ykt.core;

public class ResultBean {
    public static final Integer SUCCESS = 1;
    public static final Integer FAILURE = -1;
    //提示信息
    private String msg = "";
    //状态
    private int code = FAILURE;
    //
    private static Object data;

    public ResultBean(){}
    public ResultBean(Object data,Integer code){
        this.data=data;
        this.code=code;
    }
    public ResultBean(String msg){
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultBean success(Object data){
        return new ResultBean(data, SUCCESS);
    }
    public static ResultBean failure(String msg){
        return new ResultBean(msg);
    }
}
