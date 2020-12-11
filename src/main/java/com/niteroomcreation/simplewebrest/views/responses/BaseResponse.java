package com.niteroomcreation.simplewebrest.views.responses;

import com.niteroomcreation.simplewebrest.utils.Constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by monta on 10/12/20
 * please make sure to use credit when you're using people's code
 */
public class BaseResponse {

    protected Object data;

    public BaseResponse(Object data) {
        this.data = data;
    }

    public HashMap<String, Object> constructResponses() {

        HashMap<String, Object> resp = constructingMsg();

        if (data instanceof List<?>)
            resp.put("data", data);
        else {
            if (data != null) {
                resp.put("data", Collections.singletonList(data));
            } else {
                resp.put("data", Collections.emptyList());
            }
        }

        return resp;
    }

    private HashMap<String, Object> constructingMsg(){

        HashMap<String, Object> resp = new HashMap<>();

        if(data instanceof List<?>){
            if(((List<?>)data).isEmpty()){
                resp.put("message", Constants.DATA_EMPTY);
//                resp.put("code", )
            }
        }

        return new HashMap<>();
    }
}
