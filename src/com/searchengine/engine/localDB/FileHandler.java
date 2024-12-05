package com.searchengine.engine.localDB;

import java.io.*;
import java.util.*;

public class FileHandler {
    final private String directoryPath;

    /**
     * Constructor to initialize FileHandler with a specific directory path.
     * Validates if the directory exists; if not, throws an IllegalArgumentException.
     */
    public FileHandler(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }
        this.directoryPath = directoryPath;
    }


    /**
     * Lists all files in the directory that match the given extension.
     * @param extension - The file extension to filter by (e.g., ".txt").
     * @return An array of File objects matching the specified extension.
     */
    public File[] listFiles(String extension) {
        File directory = new File(directoryPath);
        return directory.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
    }


    /**
     * Reads the content of a given file and returns it as a single string.
     * Uses BufferedReader for efficient reading of large files.
     * @param file - The File object to be read.
     * @return The content of the file as a String.
     * @throws IOException if the file cannot be read.
     */
    public String readFileContent(File file) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            throw new IllegalArgumentException();
        }

        return String.join("\n", lines).trim();
    }


    /**
     * Validates a file by checking its existence, readability, and ensuring it is not a directory.
     * @param file - The File object to validate.
     * @return True if the file is valid; false otherwise.
     */
    private boolean validateFile(File file) {
        return file.exists() && file.isFile() && file.canRead();
    }


    /**
     * Returns the size of the file in bytes.
     * @param file - The File object whose size is to be retrieved.
     * @return The size of the file in bytes.
     */
    public long getFileSize(File file) {
        return file.length();
    }


    /**
     * Extracts the base name (without extension) of the given file.
     * @param file - The File object to process.
     * @return The file name without its extension.
     */
    public String getFileNameWithoutExtension(File file) {
        String name = file.getName();
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? name : name.substring(0, dotIndex);
    }


    /**
     * Writes the given content to a file. Creates the file if it doesn't exist.
     * @param fileName - The name of the file to write to.
     * @param content - The content to write into the file.
     */
    public void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + "/" + fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }


    /**
     * Deletes the specified file from the directory.
     * @param fileName - The name of the file to delete.
     * @return True if the file was successfully deleted; false otherwise.
     */
    public boolean deleteFile(String fileName) {
        File file = new File(directoryPath + "/" + fileName);
        return file.delete();
    }
    

    /**
     * Retrieves metadata of a given file, such as size, last modified time, and name.
     * @param file - The File object to analyze.
     * @return A Map containing metadata as key-value pairs.
     */
    public Map<String, Object> getFileMetadata(File file) {
        Map<String, Object> metadata = new HashMap<>();
        if (validateFile(file)) {
            metadata.put("FileName", file.getName());
            metadata.put("Size (bytes)", file.length());
            metadata.put("LastModified", new Date(file.lastModified()));
        } else {
            metadata.put("Error", "Invalid or inaccessible file.");
        }
        return metadata;
    }
}
