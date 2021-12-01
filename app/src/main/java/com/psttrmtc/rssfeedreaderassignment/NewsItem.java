package com.psttrmtc.rssfeedreaderassignment;

public class NewsItem {
    String newsName;
    int newsImage;

    public NewsItem(String newsName, int newsImage) {
        this.newsName = newsName;
        this.newsImage = newsImage;
    }

    public String getNewsName() {
        return newsName;
    }

    public int getNewsImage() {
        return newsImage;
    }
}
