package demo;

import java.util.ArrayList;
import java.util.List;

import pojo.MyTweet;
import twitter4j.*;

public class TweetManager {
    public static void main(String[] args) {
        getTweets("tweet");
    }
    public static ArrayList<MyTweet> getTweets(String topic) {
        Twitter twitter = GetConfiguration.getNewInstance();
        ArrayList<MyTweet> tweetList = new ArrayList<MyTweet>();
        try {
            Query query = new Query(topic);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    MyTweet myTweet = new MyTweet();
                    myTweet.setLocation(tweet.getUser().getLocation());
                    myTweet.setText(tweet.getText());
                    myTweet.setTweetID(tweet.getId());
                    URLEntity[] urlEntities = tweet.getURLEntities();
                    for(URLEntity url : urlEntities){
                        myTweet.setUrl(url.getURL());
                    }
                    myTweet.setUsername(tweet.getUser().getName());
                    tweetList.add(myTweet);
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        return tweetList;
    }
}
