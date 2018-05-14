package com.ken.common;


import java.io.Serializable;

public class  ReturnData<T> implements BaseResult,Serializable {
    private int code;

    private T data;

    public ReturnData(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
