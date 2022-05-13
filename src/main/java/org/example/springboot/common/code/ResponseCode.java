package org.example.springboot.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    //앞 세글자: http status , 뒤 세글자: 사용자 지정

    GET(200000 , "success" , HttpStatus.OK),
    POST(201000 , "Successfully added data" , HttpStatus.CREATED) ,
    PUT(201001 , "Successfully updated data" , HttpStatus.CREATED) ,
    DELETE(201002 , "Successfully deleted data" , HttpStatus.CREATED),
    //에러관련
    BAD_REQUEST(400000 ,  "파라미터 정보를 확인하세요" , HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;

    ResponseCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    ResponseCode(int code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
