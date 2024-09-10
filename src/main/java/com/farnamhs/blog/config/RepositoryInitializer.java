package com.farnamhs.blog.config;

import com.farnamhs.blog.exception.RepositoryFailException;
import com.farnamhs.blog.util.FileHandler;

import java.io.IOException;
import java.nio.file.Path;

public class RepositoryInitializer {

    public static void initialize(String path) {
        try {
            FileHandler.createDirectory(Path.of(path));
        } catch (IOException e) {
            throw new RepositoryFailException("Failed to create Repository: " + path, e);
        }
    }
}
