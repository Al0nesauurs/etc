package net.mikelab.twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GET_searchTweets {
	private static final String CONSUMER_KEY = "";
	private static final String CONSUMER_SECRET = "";

	public static void main(String[] args) throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		
		String accessToken = "";
		String accessTokenSecret = "";
		AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(oathAccessToken);

		try {
			System.out.print("Enter query to be searched for: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String hashtag = br.readLine();
			Query query = new Query(hashtag);
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
	}
}
