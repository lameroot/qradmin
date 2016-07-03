package com.qr.qradmin.enums;

public enum ErrorCode {
    INTERNAL_ERROR("1", "Internal error"),
    ACCESS_DENIED("2", "Access denied"),
    BAD_REQUEST("3", "Bad request"),
    VALIDATION_FAILED("4", "Validation failed %s"),
    WRONG_AUTHORITY_NAME("8", "Wrong authority name [%s]"),
    USER_ALREADY_CREATED("9", "User already created [%s]"),
    INTERNAL_ERROR_N("10", "Internal error [%s]"),
    ELEMENT_NOT_FOUND("11", "Element with specified id not found [%s]"),
    USER_NAME_NOT_UNIQUE("12", "User`s name is not unique [%s]"),
    UPLOADING_FILE_IS_EMPTY("13", "Uploading file is empty"),
    UNKNOWN_IMAGE_FORMAT("14", "Unknown image format"),
    UNSUPPORTED_OPERATION("16", "Unsupported operation"),
    CANT_PARSE_FILTER_QUERY("17", "Can not parse filter query"),
    MISSING_REQUIRED_PARAMS("18", "Missing required parameter [%s]"),
    MAX_UPLOAD_SIZE_EXCEEDED("19", "Max upload size = [%s]"),
    WRONG_AUTHORISATION_DATA("20", "Wrong authorisation data"),
    NOT_OWNER("23", "You should be an owner");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
