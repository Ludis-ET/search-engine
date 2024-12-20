package engine.localDB;

import java.util.*;

public class Indexer {
    private final Map<String, Set<String>> index;

    public Indexer() {
        index = new HashMap<>();
    }

    public void indexFile(String fileName, String content) {
        String[] words = content.toLowerCase().split("\\W+");
        for (String word : words) {
            index.computeIfAbsent(word, k -> new HashSet<>()).add(fileName);
        }
    }

    public Set<String> search(String word) {
        return index.getOrDefault(word.toLowerCase(), new HashSet<>());
    }
}
