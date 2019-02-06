package pojo;

import java.util.Date;

public class MyTweet {
    private long tweetID;
    private String username;
    private String url;
    private String location;
    private String text;
    private int sentiment;

    public int getSentiment() {
        return sentiment;
    }


    public long getTweetID() {
        return tweetID;
    }

    public String getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTweetID(long tweetID) {
        this.tweetID = tweetID;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "tweetID:" + getTweetID()
                + "       " + "username:" + getUsername()
                + "       " + "url:" + getUrl()
                + "       " + "location:" + getLocation()
                + "       " + "text:" + getText()
                + "       " + "sentiment:" + getSentiment();
    }
}
