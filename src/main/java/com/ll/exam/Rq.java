package com.ll.exam;

public class Rq {
    String url;

    Rq(String url){
        this.url = url;
    }

    public int getIntParam(String _queryParam, int DefaultValue){
        String[] urlBits = url.split("\\?", 2);
        urlBits = urlBits[1].split("&");

        for (String urlBit : urlBits){
            String[] query = urlBit.split("=");
            String queryParam = query[0];
            String queryValue = query[1];

            if(queryParam.equals(_queryParam)){
                return Integer.parseInt(queryValue);
            }
        }
        return DefaultValue;
    }
}
