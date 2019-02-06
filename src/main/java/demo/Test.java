package demo;

import dao.TweetDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.MyTweet;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        TweetDao tweetDao = session.getMapper(TweetDao.class);
        String topic = "china";
        ArrayList<MyTweet> tweets = TweetManager.getTweets(topic);
        StanfordEnglishNlpExample.init();
        for(MyTweet tweet : tweets) {
//            System.out.println(tweet + " : " + StanfordEnglishNlpExample.findSentiment(tweet));
            tweet.setSentiment(StanfordEnglishNlpExample.findSentiment(tweet.getText()));
            tweetDao.insertMyTweet(tweet);
        }
        List<MyTweet> myTweets = tweetDao.getAllTweet();
        for(MyTweet myTweet : myTweets)
            System.out.println(myTweet.toString());

    }
}
