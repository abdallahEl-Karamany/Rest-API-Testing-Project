package utils;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.apiKey;
import static utils.Constants.token;

public class Headers {
    public static Map<String,String> generalHeaders(){
        Map<String,String> headers=new HashMap<>();
        headers.put("Authorization",token);
        headers.put("x-api-key",apiKey);
        headers.put("Content-Type","application/json");
        return headers;
    }
    public static Map<String,String> generalHeaders(String token){
        Map<String,String> headers=new HashMap<>();
        headers.put("Authorization",token);
        headers.put("x-api-key",apiKey);
        headers.put("Content-Type","application/json");
        return headers;
    }
}
