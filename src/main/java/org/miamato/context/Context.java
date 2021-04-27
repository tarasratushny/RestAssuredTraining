package org.miamato.context;

import io.restassured.response.Response;
import java.util.HashMap;

public class Context {

    private static Context instance;

    private static HashMap<String, Response> responses;

    private Context(){
        responses = new HashMap<>();
    }

    public static Context getInstance(){
        if(instance == null)
            instance = new Context();
        return instance;
    }

    public void addResponse(String call, Response responseBody){
        responses.put(call, responseBody);
    }

    public Response getResponse(String call){
        return responses.get(call);
    }

}
