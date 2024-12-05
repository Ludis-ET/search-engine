package com.searchengine;

import com.searchengine.engine.localDB.Indexer;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "db"; // Path to the directory containing text files

        // Create an Indexer instance and build the index
        Indexer indexer = new Indexer();
        indexer.buildIndex(directoryPath);

        // Print all indexed files and their content
        indexer.printIndexedFiles();

        // Retrieve specific file content
        String fileName = "file1.txt";
        String content = indexer.getFileContent(fileName);
        System.out.println("Content of " + fileName + ":");
        System.out.println(content);
    }
}
