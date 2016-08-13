package com.qr.qradmin.generic;

public class Response {
    private boolean successful = true;
    private String message = "successful";
    private String code = "0";

    public static final Response SUCCESSFUL = new Response();

    public Response() {
    }

    public Response(boolean successful, String message, String code) {
        this.successful = successful;
        this.message = message;
        this.code = code;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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
