package com.searchengine.engine.localDB;

import java.io.File;
import java.util.*;

public class Indexer {
    final private Map<String, List<String>> index;
    final private FileHandler fileHandler;

    public Indexer(String directoryPath) {
        this.index = new HashMap<>();
        this.fileHandler = new FileHandler(directoryPath);
    }


    /**
     * Reads all the files in the directory, extracts words, and updates the index.
     */
    public void indexFiles(String extention) {
        File[] files = fileHandler.listFiles(extention);
        for (File file : files) {
            String content = fileHandler.readFileContent(file);
            String[] words = content.split("\\W+"); 
            for (String word : words) {
                word = word.toLowerCase();
                index.computeIfAbsent(word, k -> new ArrayList<>()).add(file.getName());
            }
        }
    }


    /**
     * Searches for the specified query in the index and returns a list of files that contain the word.
     * @param query The word to search for.
     * @return A list of file names that contain the query word.
     */
    public List<String> search(String query) {
        query = query.toLowerCase();
        return index.getOrDefault(query, new ArrayList<>());
    }


    /**
     * Returns the current index.
     * @return A map representing the index of words to file names.
     */
    public Map<String, List<String>> getIndex() {
        return index;
    }
    

    /**
     * Displays the entire index for debugging purposes.
     */
    public void displayIndex() {
        for (Map.Entry<String, List<String>> entry : index.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " -> Files: " + entry.getValue());
        }
    }
}
