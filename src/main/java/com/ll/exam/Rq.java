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

        // 명령 저장
        cmd = urlBits[0];

        // 파라미터 있으면 생성
        if(urlBits.length == 2) {
            createParamMap(urlBits[1]);
        }
    }

    private void createParamMap(String query) {
        paramMap = new HashMap<>();

        String[] queries = query.split("&");

        // 제대로 된 쿼리인지 확인
        for (String queryParam : queries) {
            String[] paramAndValue = queryParam.split("=", 2);

            if ( !(queryParam.contains("=")) || !(paramAndValue[1].matches("-?\\d+(\\.\\d+)?")) ) {
                return;
            }
        }

        // 저장
        for(String queryParam : queries){
            queryParam = queryParam.trim();
            String[] paramAndValue = queryParam.split("=", 2);
            paramMap.put(paramAndValue[0].trim(), Integer.parseInt(paramAndValue[1].trim()));
        }
    }

    public String getCmd() {
        return this.cmd;
    }

    public Integer getParamValue(String param) {
        int defaultValue = 0;

        if(!paramMap.containsKey(param))
            return defaultValue;

        Integer value = paramMap.get(param);
        if(value == null)
            return defaultValue;

        return value;
    }

    public Map<String, Integer> getParamMap() {
        if(paramMap == null ) return null;
        return paramMap;
    }
}
