package engine.localdb;

import java.io.File;
import java.util.*;

public class Indexer {
    private final Map<File, List<String>> fileIndex = new HashMap<>();

    public void indexFiles(List<File> files, FileHandler fileHandler) {
        for (File file : files) {
            List<String> content = fileHandler.readFileContent(file);
            fileIndex.put(file, content);
        }
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<File, List<String>> entry : fileIndex.entrySet()) {
            List<String> lines = entry.getValue();
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).toLowerCase().contains(query.toLowerCase())) {
                    results.add("\n\nFound in: " + entry.getKey().getName() + " at line " + (i + 1) + "\n\t=> " + lines.get(i));
                }
            }
        }
        return results;
    }
}
