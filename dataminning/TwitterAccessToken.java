package net.mikelab.twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAccessToken {
	private static final String CONSUMER_KEY = "";
	private static final String CONSUMER_SECRET = "";

	public static void main(String[] args) throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		RequestToken requestToken = twitter.getOAuthRequestToken();
		AccessToken accessToken = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (accessToken == null) {
			System.out.println("Open the following URL and grant access to your account:");
			System.out.println(requestToken.getAuthenticationURL());
			System.out.print("Enter the PIN (if available) or just hit enter. [PIN]: ");
			String pin = br.readLine();
			try {
				if (pin.length() > 0)
					accessToken = twitter.getOAuthAccessToken(requestToken, pin);
				else
					accessToken = twitter.getOAuthAccessToken();
			} catch (TwitterException e) {
				if (e.getStatusCode() == 401)
					System.out.println("Unable to get the access token.");
				else
					e.printStackTrace();
			}
		}
		System.out.println("Access Token: " + accessToken.getToken());
		System.out.println("Access Token Secret: " + accessToken.getTokenSecret());
	}
}
