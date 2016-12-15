package com.qr.qradmin.generic;

import com.qr.qradmin.enums.ErrorCode;

import java.util.Arrays;

/**
 * Created by Smirnov_Y on 11.12.2014.
 */
public class GeneralException extends RuntimeException {
    private ErrorCode errorCode;
    private Object[] args;

    public GeneralException(ErrorCode errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String getMessage() {
        return "errorCode=" + errorCode +
                ", args=" + Arrays.toString(args);
    }

    @Override
    public String toString() {
        return "GeneralException{" +
                "errorCode=" + errorCode +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
