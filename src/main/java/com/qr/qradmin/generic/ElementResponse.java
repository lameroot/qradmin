package com.qr.qradmin.generic;

public class ElementResponse<E> extends Response {
    private E data;

    public ElementResponse(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
