package com.bot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class BrowserBot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String topic = s.nextLine();
        String searchTerm = topic;

        try {
            String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");

            String googleUrl = "https://www.google.com/search?q=" + encodedSearchTerm;

            Document doc = Jsoup.connect(googleUrl).get();

            Elements searchResults = doc.select("div.g");

            for (Element result : searchResults) {
                Element titleElement = result.selectFirst("h3");
                Element linkElement = result.selectFirst("a[href]");
                String title = titleElement.text();
                String url = linkElement.attr("href");
                System.out.println("Title: " + title);
                System.out.println("URL: " + url);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
