package com.searchengine.engine;

import com.searchengine.engine.localDB.FileHandler;
import com.searchengine.engine.localDB.Indexer;
import java.io.File;
import java.util.*;


public class SearchManager {
    private final FileHandler fileHandler;
    private final Indexer indexer;

    public SearchManager(String dbPath) {
        this.fileHandler = new FileHandler(dbPath);
        this.indexer = new Indexer();

        // Index all files in the db folder during initialization
        File[] files = fileHandler.listFiles(".txt");
        if (files != null) {
            for (File file : files) {
                String content = fileHandler.readFileContent(file);
                indexer.indexFile(file.getName(), content);
            }
        }
    }

    public String search(String query) {
        query = query.toLowerCase();
        List<String> resultFiles = indexer.search(query);
        List<String> results = new ArrayList<>();

        for (String fileName : resultFiles) {
            List<String> lines = fileHandler.getLinesContainingWord(fileName, query);
            for (int i = 0; i < lines.size(); i++) {
                results.add("File: " + fileName + " | Line " + (i + 1) + ": " + lines.get(i));
            }
        }

        return String.join("\n", results);
    }

    public String getFileContentByIndex(int index) {
        File file = fileHandler.getFileByIndex(index);
        return file != null ? fileHandler.readFileContent(file) : "File not found.";
    }
}