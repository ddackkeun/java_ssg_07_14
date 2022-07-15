package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String url;
    private String cmd;
    private Map<String, Integer> paramMap;
    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);

        cmd = urlBits[0];

        if (urlBits.length == 2) {
            paramMap = new HashMap<>();

            String query = urlBits[1];
            String[] queryParams = query.split("&");

            for(String queryParam : queryParams){
                String[] paramAndValue = queryParam.split("=", 2);

                if(paramAndValue.length == 1) continue;

                paramMap.put(paramAndValue[0].trim(), Integer.parseInt(paramAndValue[1].trim()));
            }
        }
    }

    public String getCmd() {
        return this.cmd;
    }

    public Integer getParamValue(String param, int defaultValue) {
        if(!paramMap.containsKey(param))
            return defaultValue;

        return paramMap.get(param);
    }

}
