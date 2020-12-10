package com.niteroomcreation.simplewebrest.views.responses;

/**
 * Created by monta on 10/12/20
 * please make sure to use credit when you're using people's code
 */
public class BaseResponse {

    protected Object data;

    public BaseResponse(Object data) {
        this.data = data;
    }

    public BaseResponse constructResponses(){

        return this;
    }
}
