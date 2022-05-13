package org.example.springboot.common.response;

import org.example.springboot.common.code.ResponseCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomResponseEntity<T> {


    public ResponseEntity<Map> data(T object, ResponseCode responseCode) {

        Map<String , Object> map = new HashMap<>();
        map.put("code" , responseCode.getCode());
        map.put("message" , responseCode.getMessage());
        map.put("data" , object);
        return new ResponseEntity<>(map , responseCode.getHttpStatus());
    }


    public static ResponseEntity<Map> error(ResponseCode responseCode) {

        Map<String , Object> map = new HashMap<>();
        map.put("code" , responseCode.getCode());
        map.put("message" , responseCode.getMessage());
        return new ResponseEntity<>(map , responseCode.getHttpStatus());
    }

    public static ResponseEntity<Map> error(String message , ResponseCode responseCode) {

        Map<String , Object> map = new HashMap<>();
        map.put("code" , responseCode.getCode());
        map.put("message" , message);
        return new ResponseEntity<>(map , responseCode.getHttpStatus());
    }


}
