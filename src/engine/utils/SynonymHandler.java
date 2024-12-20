package engine.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynonymHandler {
    private final Map<String, List<String>> synonymsMap = new HashMap<>();

    public SynonymHandler() {
        synonymsMap.put("quick", List.of("fast", "speedy", "rapid"));
        synonymsMap.put("search", List.of("find", "lookup", "query"));
        // Add more synonyms as needed
    }

    public List<String> getSynonyms(String word) {
        return synonymsMap.getOrDefault(word, new ArrayList<>());
    }
}
