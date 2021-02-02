package com.ubb.pcis2083.soa.articles.external;

import com.ubb.pcis2083.soa.articles.Article;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


// https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post
public class NewsAPI {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String newsAPI = "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=25064802a12e4d42aa018f4428bd9f05";

    public static List<Article> getExternalArticles() throws Exception {
        URL obj = new URL(newsAPI);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            List<Article> articles = new ArrayList<>();

            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonArticle = (JSONObject) jsonArray.get(i);
                try {
                    String title = (String) jsonArticle.get("title");
                    String text = (String) jsonArticle.get("content");

                    Article article = Article.newBuilder().setText(text).setTitle(title).setLabelId(0L).build();
                    articles.add(article);
                }
                catch (Exception e) {
                    System.out.println("Failed an article");
                }
            }

            return articles;
        } else {
            return new ArrayList<>();
        }
    }
}
