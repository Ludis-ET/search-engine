package engine.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public List<String> scrapeContent(String url, String cssQuery) throws IOException {
        List<String> content = new ArrayList<>();
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(cssQuery);

        for (var element : elements) {
            content.add(element.text());
        }

        return content;
    }
}
