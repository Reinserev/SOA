package com.ubb.pcis2083.soa.news.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static String cleanString(String article) {
        List<String> articleLines = new ArrayList<>(Arrays.asList(article.split("\n")));

        while (articleLines.size() > 1 && articleLines.get(0).length() != 0)
            articleLines.remove(0);
        String cleanedArticle = articleLines.stream().collect(Collectors.joining());
        cleanedArticle = cleanedArticle.substring(0, Math.min(cleanedArticle.length(), 100));
        cleanedArticle = cleanedArticle.replace("\n"," ");

        // Replace the & character with &amp;
        //Replace the < character with &lt;
        //Replace the > character with &gt;

        cleanedArticle = cleanedArticle.replace("&","&amp");
        cleanedArticle = cleanedArticle.replace("<","&lt");
        cleanedArticle = cleanedArticle.replace(">","&gt");

        return cleanedArticle;
    }

    /**
     * returns a view (not a new list) of the sourceList for the
     * range based on page and pageSize
     * @param sourceList
     * @param page, page number should start from 1
     * @param pageSize
     * @return
     * custom error can be given instead of returning emptyList
     */
    public static <T> List<T> getPage(List<T> sourceList, int pageSize, int page) {
        if(pageSize <= 0 || page <= 0) {
            throw new IllegalArgumentException("invalid page size: " + pageSize);
        }

        int fromIndex = (page - 1) * pageSize;
        if(sourceList == null || sourceList.size() <= fromIndex){
            return Collections.emptyList();
        }

        // toIndex exclusive
        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
    }
}
