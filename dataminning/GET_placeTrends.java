package net.mikelab.twitter;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GET_placeTrends {
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
			int woeidGlobal = 1, woeidUS = 23424977;
			Trends trends = twitter.getPlaceTrends(woeidGlobal);
			
			for (Trend trend : trends.getTrends())
				System.out.println(trend.getName());
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends/place: " + te.getMessage());
		}
	}

	public static void main(String[] args) {
		new GET_placeTrends().start();
	}
}
