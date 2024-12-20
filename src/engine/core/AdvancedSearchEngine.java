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

    @Override
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void indexFiles(List<File> files) {
        indexer.indexFiles(files, fileHandler);
    }

    @Override
    public List<String> search(String query) {
        List<String> results = new ArrayList<>();

        String correctedQuery = spellChecker.correct(query);
        results.addAll(indexer.search(correctedQuery));

        List<String> synonyms = synonymHandler.getSynonyms(correctedQuery);
        for (String synonym : synonyms) {
            results.addAll(indexer.search(synonym));
        }

        return results.isEmpty() ? List.of("No results found for: " + correctedQuery) : results;
    }
}
