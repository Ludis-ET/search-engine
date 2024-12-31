package engine.web;

import java.util.ArrayList;
import java.util.List;

public class WebsiteHandler {
    private final List<String> websites = new ArrayList<>();

    public void addWebsite(String url) {
        if (url != null && url.startsWith("http")) {
            websites.add(url);
        }
    }

    public List<String> getWebsites() {
        return new ArrayList<>(websites);
    }
}
