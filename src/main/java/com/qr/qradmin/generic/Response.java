package com.qr.qradmin.generic;

public class Response {
    private boolean error = false;
    private String message = "successful";
    private String code = "0";

    public static final Response SUCCESSFUL = new Response();

    public Response() {
    }

    public Response(boolean error, String message, String code) {
        this.error = error;
        this.message = message;
        this.code = code;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
