package com.niteroomcreation.simplewebrest.views.responses;

import java.util.HashMap;

/**
 * Created by monta on 10/12/20
 * please make sure to use credit when you're using people's code
 */
public class BaseResponse {

    //need to make it less generic
    protected Object data;

    public BaseResponse(Object data) {
        this.data = data;
    }

    public HashMap<String, Object> constructResponses(){

        HashMap<String, Object> resp = new SuccessResponse("data to message", 9).constructMsg();
        resp.put("data", data);

        return resp;
    }
}
