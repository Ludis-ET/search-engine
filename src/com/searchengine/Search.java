package com.searchengine;

public class Search {
    /**
     * Main method is the entry point of the Search Engine application.
     * - This class initiates the search engine, loads documents, and handles user queries.
     * - It demonstrates the use of class inheritance and composition:
     *      1. SearchEngine inherits functionality from the base class FileReader (through composition, not inheritance in this case).
     *      2. The Document class holds content and is used as a data model in the SearchEngine class.
     *      3. The FileReader utility class is used for reading file contents.
     *      4. The SearchEngine is responsible for coordinating document loading and querying.
     * 
     * Process:
     * 1. Create an instance of SearchEngine.
     * 2. Load documents from the "db" folder using composition with the FileReader class.
     * 3. Perform search using the SearchEngine class' search method, which matches the query with document content.
     * 4. Display results in the terminal.
     */
    public static void main(String[] args) {
        System.out.println("main class");
    }
}
