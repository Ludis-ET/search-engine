package engine.localdb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final String directoryPath;

    public FileHandler(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    // Updated to accept multiple file extensions
    public List<File> listFiles(String... extensions) {
        List<File> files = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    String fileName = file.getName().toLowerCase();
                    for (String ext : extensions) {
                        if (fileName.endsWith(ext)) {
                            files.add(file);
                            break;
                        }
                    }
                }
            }
        }
        return files;
    }

    // Updated to handle different file types
    public List<String> readFileContent(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }

            // Additional logic can be added here for more complex parsing if needed (e.g., for CSV, XML, JSON).
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".csv") || fileName.endsWith(".xml") || fileName.endsWith(".json")) {
                // For these types, we'll just return the content as text for now.
                // You can add more sophisticated parsing here later if required.
                return content;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    // Retrieve a file by its name
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
