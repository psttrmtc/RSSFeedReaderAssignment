package com.psttrmtc.rssfeedreaderassignment;

public class RSSItem {

    private String title;
    private String description;
    private String pubDate;

    private String link;


    public RSSItem(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }



    public String getLink() {
        return link;
    }
    @Override
    public String toString() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }



    public void setLink(String link) {
        this.link = link;
    }
}
