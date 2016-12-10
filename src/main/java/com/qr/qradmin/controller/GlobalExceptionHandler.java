package com.qr.qradmin.controller;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.GeneralException;
import com.qr.qradmin.generic.Response;
import com.qr.qradmin.service.ErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.annotation.Resource;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ErrorService errorsService;

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleAllException(Throwable ex) {
        logger.error("Unexpected exception ", ex);
        return errorsService.generateErrorResponse(ErrorCode.INTERNAL_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Response handleAccessDeniedException(AccessDeniedException ex) {
        logger.error("Access denied ", ex);
        return errorsService.generateErrorResponse(ErrorCode.ACCESS_DENIED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleAccessDeniedException(MissingServletRequestParameterException ex) {
        logger.error("Bad request (some params are missing)", ex);
        return errorsService.generateErrorResponse(ErrorCode.MISSING_REQUIRED_PARAMS, ex.getParameterName());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response maxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        logger.error("Max upload size exceeded", ex);
        return errorsService.generateErrorResponse(ErrorCode.MAX_UPLOAD_SIZE_EXCEEDED, ex.getMaxUploadSize());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleAccessDeniedException(HttpMessageNotReadableException ex) {
        logger.error("Bad request", ex);
        return errorsService.generateErrorResponse(ErrorCode.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleBindException(BindException ex) {
        logger.error("Validation error", ex);
        return errorsService.generateErrorResponse(ErrorCode.VALIDATION_FAILED, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("Validation error", ex);
        return errorsService.generateErrorResponse(ErrorCode.VALIDATION_FAILED, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(GeneralException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleGeneralException(GeneralException ex) {
        if ( ex.getErrorCode() != ErrorCode.ACCESS_DENIED ) {
            logger.error(ex.toString(), ex);
        }
        return errorsService.generateErrorResponse(ex.getErrorCode(), ex.getArgs());
    }
}
