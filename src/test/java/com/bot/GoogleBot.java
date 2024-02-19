package com.bot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.*;
import java.awt.*;
import java.util.List;

public class GoogleBot {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String topic = s.nextLine();
        String searchTerm = topic;

        try {
            String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");

            String googleUrl = "https://www.google.com/search?q=" + encodedSearchTerm;

            Document doc = Jsoup.connect(googleUrl).get();

            Elements searchResults = doc.select("div.g");

            List<String> urls = new ArrayList<>();
            for (Element result : searchResults) {
                Element linkElement = result.selectFirst("a[href]");
                String url = linkElement.attr("href");
                urls.add(url);
            }

            for (String url : urls) {
                openURLInBrowser(url);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void openURLInBrowser(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url));
        } else {
            System.out.println("Desktop browsing is not supported.");
        }
    }
}
