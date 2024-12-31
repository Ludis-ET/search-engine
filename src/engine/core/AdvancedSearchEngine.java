package engine.core;

import engine.localdb.FileHandler;
import engine.localdb.Indexer;
import engine.utils.SpellChecker;
import engine.utils.SynonymHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchEngine extends SearchEngine {
    private final Indexer indexer = new Indexer();
    private FileHandler fileHandler;
    private final SpellChecker spellChecker = new SpellChecker();
    private final SynonymHandler synonymHandler = new SynonymHandler();

    // Set the file handler to be used by the search engine
    @Override
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    // Get the current file handler being used by the search engine
    public FileHandler getFileHandler() {
        return fileHandler;
    }

    // Index the provided list of files using the indexer
    @Override
    public void indexFiles(List<File> files) {
        indexer.indexFiles(files, fileHandler);
    }

    // Perform a search based on the provided query, applying spell correction and synonyms
    @Override
    public List<String> search(String query) {
        List<String> results = new ArrayList<>();

        // Correct the spelling of the query
        String correctedQuery = spellChecker.correct(query);
        results.addAll(indexer.search(correctedQuery));

        // Get and search with synonyms of the corrected query
        List<String> synonyms = synonymHandler.getSynonyms(correctedQuery);
        for (String synonym : synonyms) {
            results.addAll(indexer.search(synonym));
        }

        // Return results or a message if no results are found
        return results.isEmpty() ? List.of("No results found for: " + correctedQuery) : results;
    }
}
