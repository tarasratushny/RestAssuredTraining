package org.miamato.context;

import io.restassured.response.Response;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Context {

    private static Context instance;

    private static HashMap<String, Response> responses= new HashMap<>();
    private static HashMap<String, Integer> ids = new HashMap<>();
    private static HashMap<String, LocalDateTime> dates = new HashMap<>();

    private Context() {
        responses = new HashMap<>();
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public Context addResponse(String call, Response responseBody) {
        responses.put(call, responseBody);
        return instance;
    }

    public Response getResponse(String call) {
        return responses.get(call);
    }

    public Context addId(String idName, int id){
        ids.put(idName, id);
        return instance;
    }

    public int getId(String idName){
        return ids.get(idName);
    }

    public Context addDate(String name, LocalDateTime date){
        dates.put(name, date);
        return instance;
    }

    public LocalDateTime getDate(String name){
        return dates.get(name);
    }

}
