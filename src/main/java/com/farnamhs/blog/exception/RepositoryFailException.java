package com.farnamhs.blog.exception;

import java.io.IOException;

public class RepositoryFailException extends RuntimeException {
    public RepositoryFailException(String message, IOException e) {
        super(message, e);
    }

    public RepositoryFailException(String message, RuntimeException e) {
        super(message, e);
    }
}
