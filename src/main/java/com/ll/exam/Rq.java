package com.ll.exam;

import java.util.HashMap;

public class Rq {
    private String url;
    private String path;
    private HashMap<String, String> queryParams;

    Rq(String url){
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];
        this.queryParams = new HashMap<>();

        if (urlBits.length == 2){
            urlBits = urlBits[1].split("&");
            for (String urlBit: urlBits){
                String[] queryKeyValue = urlBit.split("=");
                queryParams.put(queryKeyValue[0], queryKeyValue[1]);
            }
        }
    }

    public int getIntParam(String queryParam, int DefaultValue){
        if(queryParams.containsKey(queryParam)) {
            return Integer.parseInt(queryParams.get(queryParam));
        }
        return DefaultValue;
    }

    public String getPath(){
        return this.path;
    }
}
