package com.searchengine.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class FileHandler {
    // Reads the content of a file and returns it as a String
    protected String readFileContent(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    // Lists all files in a directory with a specific extension
    protected File[] listFiles(String directoryPath, String extension) {
        File folder = new File(directoryPath);
        return folder.listFiles((dir, name) -> name.endsWith(extension));
    }
}
