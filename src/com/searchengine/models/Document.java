package com.searchengine.models;

public class Document {
    private String name;
    private String content;

    /**
     * Constructor to initialize document name and content.
     * @param name    Name of the document (e.g., file name).
     * @param content Content of the document.
     */
    public Document(String name, String content) {
        this.name = name;
        this.content = content;
    }

    // Getters for name and content (could be expanded later)
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
