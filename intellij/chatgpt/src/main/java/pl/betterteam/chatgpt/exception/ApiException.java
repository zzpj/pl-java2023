package pl.betterteam.chatgpt.exception;

import java.io.IOException;

public class ApiException extends IOException {
    public ApiException(String message) {
        super(message);
    }
}
