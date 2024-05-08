package com.ing.developer.oauth2.model;

import java.util.Map;
import java.util.Collection;

public class ApiResponse<T>{

    final private int statusCode;
    final private Map<String, Collection<String>> headers;
    final private T data;

    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     */
    public ApiResponse(int statusCode, Map<String, Collection<String>> headers) {
        this(statusCode, headers, null);
    }

    /**
     * @param statusCode The status code of HTTP response
     * @param headers The headers of HTTP response
     * @param data The object deserialized from response bod
     */
    public ApiResponse(int statusCode, Map<String, Collection<String>> headers, T data) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, Collection<String>> getHeaders() {
        return headers;
    }

    public T getData() {
        return data;
    }
  
}