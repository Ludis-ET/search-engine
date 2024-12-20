package engine.localdb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final String directoryPath;

    public FileHandler(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<File> listFiles(String extension) {
        List<File> files = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(extension)) {
                    files.add(file);
                }
            }
        }
        return files;
    }

    public List<String> readFileContent(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public File getFile(String fileName) {
        File directory = new File(directoryPath);
        for (File file : directory.listFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null; // File not found
    }
}
