package engine.core;

import java.io.File;
import java.util.List;

public abstract class SearchEngine {
    public abstract void indexFiles(List<File> files);

    public abstract List<String> search(String query);

    public abstract void setFileHandler(engine.localdb.FileHandler fileHandler);
}
