package com.ben.useraccountmanagement.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private int status;
    private T data;
    private String message;
    private LocalDateTime timestamp;
    private String path;

    public ApiResponse(int status, T data, String message, String path) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    // getters
    public int getStatus(){
        return this.status;
    }

    public T getData(){
        return this.data;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }

    public String getPath(){
        return this.path;
    }


}
