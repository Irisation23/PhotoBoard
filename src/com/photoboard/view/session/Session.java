package com.photoboard.view.session;

public class Session<T> {

    private final T data;

    public Session(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
