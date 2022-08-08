package com.tweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algoworks.tweets.dto.TweetDetails;
import com.algoworks.tweets.dto.User;
import com.algoworks.tweets.response.ApplicationError;
import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UserDetailsResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;

public class TweetFactory {

	public static List<TweetDetails> getTweetDetails() {
		List<TweetDetails> tweets = new ArrayList<>();
		TweetDetails tweetDetails = new TweetDetails();
		tweetDetails.setTweetIdStr("311975360667459585");
		tweetDetails.setTweetId(311975360667459585L);
		tweetDetails.setCreatedAt("Wed Mar 13 23:01:36 +0000 2013");
		tweetDetails.setText(
				"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm feature 6oSeEIEUr");
		User user = new User();
		user.setId(2384071);
		user.setDescription(
				"Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.");
		user.setLocation("Sebastopol, CA");
		user.setScreenName("timoreilly");
		user.setName("Tim O'Reilly");
		user.setUserCreatedAt("Tue Mar 27 01:14:05 +0000 2007");
		tweetDetails.setUser(user);
		tweets.add(tweetDetails);
		return tweets;
	}

	public static List<UsersDetailsResponse> getAllUsersDetailsResponses() {
		List<UsersDetailsResponse> usersDetailsList = new ArrayList<>();
		usersDetailsList.add(new UsersDetailsResponse(2384071, "timoreilly", "Sebastopol, CA", "Tim O'Reilly",
				"Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.",
				"Tue Mar 27 01:14:05 +0000 2007", "Pacific Time (US & Canada)"));
		usersDetailsList.add(new UsersDetailsResponse(633, "zephoria", "New York, NY", "danah boyd",
				"social media scholar, youth researcher & advocate | Microsoft Research, NYU Media Culture & Communication, Harvard Berkman Center | zephoria@zephoria.org",
				"Thu Jul 13 21:27:23 +0000 2006", "Eastern Time (US & Canada)"));
		return usersDetailsList;
	}

	public static UserDetailsResponse getUserDetails() {
		UserDetailsResponse userDetails = new UserDetailsResponse();
		ApplicationError error = new ApplicationError("Success", "0");
		userDetails.setApplicationError(error);
		userDetails.setUserDetails(new UsersDetailsResponse(2384071, "timoreilly", "Sebastopol, CA", "Tim O'Reilly",
				"Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.",
				"Tue Mar 27 01:14:05 +0000 2007", "Pacific Time (US & Canada)"));
		return userDetails;
	}

	public static TweetDetailsResponse getTweetDetailsResponse() {
		TweetDetailsResponse tweetDetailsResponse = new TweetDetailsResponse();
		tweetDetailsResponse.setApplicationError(new ApplicationError("Success", "0"));
		tweetDetailsResponse.setTweetDetails(new TweetsDetailResponse("311975360667459585", "", "",
				"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr",
				"Wed Mar 13 23:01:36 +0000 2013", "", 0, 0, 0, 0));
		return tweetDetailsResponse;
	}

	public static List<TweetsDetailResponse> getAllTweetsDetailResponse() {
		List<TweetsDetailResponse> detailResponse = new ArrayList<>();
		detailResponse.add(new TweetsDetailResponse("311975360667459585", null, null,
				"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr",
				"Wed Mar 13 23:01:36 +0000 2013", null, 0, 0, 0, 0));
		return detailResponse;
	}

	public static TweetsDetailResponse getTweetsDetails() {
		TweetsDetailResponse tweetRecord = new TweetsDetailResponse("311975360667459585", null, null,
				"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr",
				"Wed Mar 13 23:01:36 +0000 2013", null, 0, 0, 0, 0);
		return tweetRecord;
	}

	public static UsersDetailsResponse getUsersDetails() {
		UsersDetailsResponse userDetails = new UsersDetailsResponse(2384071, "timoreilly", "Sebastopol, CA",
				"Tim O'Reilly",
				"Founder and CEO, O'Reilly Media. Watching the alpha geeks, sharing their stories, helping the future unfold.",
				"Tue Mar 27 01:14:05 +0000 2007", "Pacific Time (US & Canada)");
		return userDetails;
	}

	public static Map<Long, Links> getAllUrls() {
		 Map<Long, Links> urlLinks = new HashMap<>();
		 Links links = new Links("http://a0.twimg.com/profile_background_images/3587880/notes.gif","https://si0.twimg.com/profile_background_images/3587880/notes.gif",null,"http://a0.twimg.com/profile_images/2823681988/f4f6f2bed8ab4d5a48dea4b9ea85d5f1_normal.jpeg", "https://si0.twimg.com/profile_images/2823681988/f4f6f2bed8ab4d5a48dea4b9ea85d5f1_normal.jpeg","http://radar.oreilly.com",
			       "http://radar.oreilly.com", null, null);
		 urlLinks.put(2384071L,links);
		return urlLinks;
		
	}

}
