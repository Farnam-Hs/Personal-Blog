package com.farnamhs.blog.util;

import com.farnamhs.blog.config.GsonLocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new GsonLocalDateAdapter().nullSafe())
            .create();

    public static <T> T readFile(Path filePath, Class<T> classType) throws IOException {
        return gson.fromJson(Files.readString(filePath), classType);
    }

    public static <T> List<T> readAllFiles(Path directoryPath, Class<T> classType) throws IOException {
        try (Stream<Path> typePathStream = Files.list(directoryPath)) {
            return typePathStream.map(typePath -> {
                try {
                    return readFile(typePath, classType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
    }

    public static <T> void writeFile(Path filePath, T t) throws IOException {
        Files.writeString(filePath, gson.toJson(t));
    }

    public static void removeFile(Path filePath) throws IOException {
        Files.delete(filePath);
    }

    public static void createDirectory(Path directoryPath) throws IOException {
        Files.createDirectories(directoryPath);
    }

    public static boolean notExists(Path path) {
        return Files.notExists(path);
    }
}
