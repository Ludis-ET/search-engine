package com.searchengine.engine;

import com.searchengine.models.Document;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    final private List<Document> documents;

    /**
     * Constructor initializes an empty list of documents.
     */
    public SearchEngine() {
        documents = new ArrayList<>();
    }

    /**
     * Simulates loading documents from the "db" folder.
     * (Actual implementation will use FileReader.)
     */
    public void loadDocuments() {
        System.out.println("Loading documents...");
        // Simulated loading logic
    }

    /**
     * Simulates searching for a query within loaded documents.
     * @param query The search query string.
     */
    public void search(String query) {
        System.out.println("Searching for: " + query);
        // Simulated search logic
    }
}
