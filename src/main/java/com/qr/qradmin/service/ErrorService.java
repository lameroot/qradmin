package com.qr.qradmin.service;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.generic.PageResponse;
import com.qr.qradmin.generic.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Collections;
import java.util.Formatter;

@Service
public class ErrorService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Response generateErrorResponse(ErrorCode errorCode, Object... args) {
        Response response = new Response();
        response.setSuccessful(false);
        response.setCode(errorCode.getCode());
        if (args.length > 0) {
            Formatter formatter = new Formatter();
            response.setMessage(formatter.format(errorCode.getMessage(), args).toString());
        } else {
            response.setMessage(errorCode.getMessage());
        }
        return response;
    }

    public ElementResponse generateErrorResponse(BindingResult result) {
        ObjectError error = result.getAllErrors().get(0);
        ElementResponse response = new ElementResponse<>(null);
        response.setSuccessful(false);
        response.setCode(error.getCode());
        response.setMessage(error.getDefaultMessage());
        return response;
    }

    public PageResponse generateErrorPageResponse(BindingResult result) {
        ObjectError error = result.getAllErrors().get(0);
        PageResponse response = new PageResponse<>(Collections.emptyList(), 0);
        response.setSuccessful(false);
        response.setCode(error.getCode());
        response.setMessage(error.getDefaultMessage());
        return response;
    }
}
