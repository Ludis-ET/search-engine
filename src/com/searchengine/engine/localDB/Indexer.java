package com.searchengine.engine.localDB;

import java.util.*;

public class Indexer {
    private final Map<String, Set<String>> invertedIndex;

    public Indexer() {
        invertedIndex = new HashMap<>();
    }

    public void indexFile(String fileName, String content) {
        String[] words = content.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            invertedIndex.computeIfAbsent(word, k -> new HashSet<>()).add(fileName);
        }
    }

    public List<String> search(String query) {
        query = query.toLowerCase();
        Set<String> results = invertedIndex.getOrDefault(query, Collections.emptySet());
        return new ArrayList<>(results);
    }
}
