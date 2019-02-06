package dao;

import pojo.MyTweet;

import java.util.List;

public interface TweetDao {
    MyTweet getTweetById(long tweetID);
    List<MyTweet> getAllTweet();
    void insertMyTweet(MyTweet myTweet);
}
