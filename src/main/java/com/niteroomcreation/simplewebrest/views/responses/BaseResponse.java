package com.niteroomcreation.simplewebrest.views.responses;

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

        HashMap<String, Object> resp = new SuccessResponse("data to message", 9).constructMsg();

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
}
