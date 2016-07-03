package com.qr.qradmin.service;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Formatter;

@Service
public class ErrorService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Response generateErrorResponse(ErrorCode errorCode, Object... args) {
        Response response = new Response();
        response.setError(true);
        response.setCode(errorCode.getCode());
        if (args.length > 0) {
            Formatter formatter = new Formatter();
            response.setMessage(formatter.format(errorCode.getMessage(), args).toString());
        } else {
            response.setMessage(errorCode.getMessage());
        }
        return response;
    }

    public Response generateErrorResponse(BindingResult result) {
        ObjectError error = result.getAllErrors().get(0);
        Response response = new Response();
        response.setError(true);
        response.setCode(error.getCode());
        response.setMessage(error.getDefaultMessage());
        return response;
    }
}
