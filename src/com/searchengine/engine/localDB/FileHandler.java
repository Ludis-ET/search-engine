package com.searchengine.engine.localDB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    final private String directoryPath;

    public FileHandler(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public File[] listFiles(String extension) {
        File directory = new File(directoryPath);
        return directory.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
    }

    public String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
        return content.toString().trim();
    }

    public long getFileSize(File file) {
        return file.length();
    }

    public String getFileNameWithoutExtension(File file) {
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public List<String> getLinesContainingWord(String fileName, String word) {
        List<String> matchingLines = new ArrayList<>();
        File file = new File(directoryPath + "/" + fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(word.toLowerCase())) {
                    matchingLines.add(line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        return matchingLines;
    }

    public File getFileByIndex(int index) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files != null && index >= 0 && index < files.length) {
            return files[index];
        }
        return null;
    }
}
