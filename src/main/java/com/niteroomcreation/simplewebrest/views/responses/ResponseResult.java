package com.niteroomcreation.simplewebrest.views.responses;

import com.niteroomcreation.simplewebrest.models.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by monta on 14/12/20
 * please make sure to use credit when you're using people's code
 */
public class ResponseResult {

    private static ResponseResult instance;

    public static synchronized ResponseResult getInstance() {
        if (instance == null)
            instance = new ResponseResult();

        return instance;
    }

    private int code;
    private String message = "";
    private List<Product> data = Collections.emptyList();

    public ResponseResult(int code, String message, List<Product> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(String message, List<Product> data) {
        this.message = message;
        this.data = data;
    }

    public ResponseResult(List<Product> data) {
        this.data = data;
    }

    private ResponseResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public void setSingleData(Product data){
        this.data = Collections.singletonList(data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
