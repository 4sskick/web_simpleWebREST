package com.niteroomcreation.simplewebrest.views.responses;

import java.util.HashMap;

/**
 * Created by monta on 10/12/20
 * please make sure to use credit when you're using people's code
 */
class SuccessResponse {

    protected String message;
    protected int code;

    public SuccessResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("message", message);
        resp.put("code", code);

        return resp.toString();
    }

    public HashMap<String, Object> constructMsg(){
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("message", message);
        resp.put("code", code);
        return resp;
    }
}
