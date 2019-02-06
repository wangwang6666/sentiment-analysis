package demo;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetConfiguration {
    public static Twitter getNewInstance(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("l5HHK9Zif6cbQLVTm2lzTQ")
                .setOAuthConsumerSecret("3Jp8X9B78MijlxgFXrp76S5mT2QkqK1iOytZ8z1sc")
                .setOAuthAccessToken("371118809-g8MSGnFNZVe1ZDHynOQF4x83vIsCkJAinI4EIhRW")
                .setOAuthAccessTokenSecret("MEeLoM0rC90gucCdVpdeuacfYvWcLIhDpaS8XDlr4Ts");
        TwitterFactory factory = new TwitterFactory(cb.build());
        Twitter twitter = factory.getInstance();
        return twitter;
    }
}

