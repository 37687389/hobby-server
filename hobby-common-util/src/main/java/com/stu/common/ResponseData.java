package com.stu.common;


import java.io.Serializable;
public class ResponseData implements Serializable{

    private static final long serialVersionUID = 7498483649536881777L;

    private Integer code;

    private String msg;

    private Object data;

    public ResponseData() {
    }

    public ResponseData(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public static ResponseData success() {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static ResponseData success(String msg) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static ResponseData success(Object data) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static ResponseData success(String msg, Object data) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static ResponseData error(String msg) {
        return new ResponseData(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static ResponseData error(Object data) {
        return new ResponseData(ResponseCode.ERROR.getCode(), null, data);
    }

    public static ResponseData error(String msg, Object data) {
        return new ResponseData(ResponseCode.ERROR.getCode(), msg, data);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
