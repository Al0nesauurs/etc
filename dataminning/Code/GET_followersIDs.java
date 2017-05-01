package net.mikelab.twitter;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GET_followersIDs {
	private static final String CONSUMER_KEY = "";
	private static final String CONSUMER_SECRET = "";

	public void start() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		
		String accessToken = "";
		String accessTokenSecret = "";
		AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(oathAccessToken);
		
		try {
			String screenName = "chronolf";
			long cursor = -1;
			IDs ids = twitter.getFollowersIDs(screenName, cursor);
			
			for (long id : ids.getIDs())
				System.out.println(id);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get followers' ids: " + te.getMessage());
		}
	}

	public static void main(String[] args) {
		new GET_followersIDs().start();
	}
}
