package com.ll.exam;

public class Rq {
    String url;
    String path;
    String queryStr;

    Rq(String url){
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];
        if (urlBits.length == 2){
            this.queryStr = urlBits[1];
        }
    }

    public int getIntParam(String _queryParam, int DefaultValue){
        String[] queryStr_ = queryStr.split("&");
        for (String urlBit : queryStr_){
            String[] query = urlBit.split("=");
            String queryParam = query[0];
            String queryValue = query[1];

            if(queryParam.equals(_queryParam)){
                return Integer.parseInt(queryValue);
            }
        }
        return DefaultValue;
    }

    public String getPath(){
        return this.path;
    }
}
