package org.example.springboot.common.exception;

import lombok.Getter;
import org.example.springboot.common.code.ResponseCode;

@Getter
public class HandleableException extends RuntimeException{

    private ResponseCode responseCode;

    public HandleableException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
        this.setStackTrace(new StackTraceElement[0]);
    }

}
