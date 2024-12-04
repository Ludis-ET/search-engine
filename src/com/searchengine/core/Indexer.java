package com.searchengine.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Indexer extends FileHandler {
    final private Map<String, String> fileContentMap; // Maps file names to their content

    public Indexer() {
        fileContentMap = new HashMap<>();
    }

    // Builds the in-memory storage by reading files from a directory
    public void buildIndex(String directoryPath) {
        File[] files = listFiles(directoryPath, ".txt");
        if (files != null) {
            for (File file : files) {
                try {
                    String content = readFileContent(file);
                    fileContentMap.put(file.getName(), content);
                } catch (IOException e) {
                    System.err.println("Error reading file: " + file.getName());
                }
            }
        } else {
            System.err.println("No files found in directory: " + directoryPath);
        }
    }

    // Retrieves the content of a file by its name
    public String getFileContent(String fileName) {
        return fileContentMap.getOrDefault(fileName, "File not found.");
    }

    // Prints all indexed files and their content
    public void printIndexedFiles() {
        fileContentMap.forEach((fileName, content) -> {
            System.out.println("File: " + fileName);
            System.out.println("Content: " + content);
            System.out.println("------");
        });
    }
}
