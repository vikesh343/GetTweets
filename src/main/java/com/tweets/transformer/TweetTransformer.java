package com.tweets.transformer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import com.tweets.jsonmodel.TweetDetails;
import com.tweets.jsonmodel.Urls;
import com.tweets.response.getalltweets.AllTweetsDetails;
import com.tweets.response.getallurls.GetAllUrlsPresentResponse;
import com.tweets.response.gettweetforid.GetTweet;
import com.tweets.response.gettweetforid.GetTweetForID;
import com.tweets.response.gettweetforuser.GetTweetDetails;
import com.tweets.response.gettweetforuser.GetTweetForUser;
import com.tweets.response.getuserdetails.UserDetails;
import com.tweets.util.ApplicationConstants;
import com.tweets.util.ApplicationError;

@Component
public class TweetTransformer {

	public AllTweetsDetails transformGetAllTweets(TweetDetails tweetDetail) {
		AllTweetsDetails allTweetsDetails = new AllTweetsDetails();
		allTweetsDetails.setId(tweetDetail.getId());
		allTweetsDetails.setTime(tweetDetail.getCreated_at());
		allTweetsDetails.setTweetText(tweetDetail.getText());
		return allTweetsDetails;
	}

	public UserDetails transformGetAllUserDetails(TweetDetails tweetDetail) {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(tweetDetail.getUser().getId_str());
		userDetails.setUserName(tweetDetail.getUser().getName());
		return userDetails;
	}

	public GetTweetForID getTweetDetailsForID(TweetDetails tweetDetail) {
		// TODO Auto-generated method stub
		GetTweetForID getTweetDetails = new GetTweetForID();
		ApplicationError error = new ApplicationError();
		GetTweet getTweet = new GetTweet();
		error.setErrorCode("0");
		error.setErrorDescription("Success.");
		getTweet.setId(tweetDetail.getUser().getId());
		getTweet.setName(tweetDetail.getUser().getName());
		getTweet.setUserName(tweetDetail.getUser().getScreen_name());
		getTweet.setText(tweetDetail.getText());
		getTweet.setRetweetCount(tweetDetail.getRetweet_count());
		getTweet.setCreatedAt(tweetDetail.getCreated_at());
		getTweetDetails.setApplicationError(error);
		getTweetDetails.setGetTweet(getTweet);
		return getTweetDetails;
	}

	public GetTweetForID getTweetDetailsForIDError() {
		GetTweetForID getTweetDetails = new GetTweetForID();
		ApplicationError error = new ApplicationError();
		error.setErrorCode("1");
		error.setErrorDescription("Invalid user ID.");
		getTweetDetails.setApplicationError(error);
		return getTweetDetails;
	}

	public GetTweetForUser getTweetDetailsForUser(TweetDetails tweetDetail) {
		GetTweetForUser getTweetDetails = new GetTweetForUser();
		ApplicationError error = new ApplicationError();
		GetTweetDetails getTweet = new GetTweetDetails();
		error.setErrorCode("0");
		error.setErrorDescription("Success.");
		getTweet.setId(tweetDetail.getUser().getId());
		getTweet.setName(tweetDetail.getUser().getName());
		getTweet.setUserName(tweetDetail.getUser().getScreen_name());
		getTweet.setText(tweetDetail.getText());
		getTweet.setRetweetCount(tweetDetail.getRetweet_count());
		getTweet.setCreatedAt(tweetDetail.getCreated_at());
		getTweet.setListedCount(tweetDetail.getUser().getListed_count());
		getTweet.setFavouritesCount(tweetDetail.getUser().getFavourites_count());
		getTweet.setFollowersCount(tweetDetail.getUser().getFollowers_count());
		getTweet.setFriendsCount(tweetDetail.getUser().getFriends_count());
		getTweetDetails.setApplicationError(error);
		getTweetDetails.setGetTweetDeatils(getTweet);
		return getTweetDetails;
	}

	public GetTweetForUser getTweetDetailsForUserError() {
		GetTweetForUser getTweetDetails = new GetTweetForUser();
		ApplicationError error = new ApplicationError();
		error.setErrorCode("1");
		error.setErrorDescription("Invalid username.");
		getTweetDetails.setApplicationError(error);
		return getTweetDetails;
	}

	public GetAllUrlsPresentResponse getAllUrlsTranfomer(TweetDetails tweetDetail) {
		GetAllUrlsPresentResponse response = new GetAllUrlsPresentResponse();
		response.setId(tweetDetail.getUser().getId());
		List<String> urls = new ArrayList<>();
		urls.add(tweetDetail.getUser().getProfile_background_image_url());
		urls.add(tweetDetail.getUser().getProfile_background_image_url_https());
		urls.add(tweetDetail.getUser().getProfile_image_url_https());
		urls.add(tweetDetail.getUser().getProfile_image_url());
		urls.add(tweetDetail.getUser().getUrl());
		urls.add(tweetDetail.getUser().getEntities().getUrl().getUrls().get(0).getDisplay_url());
		urls.add(tweetDetail.getUser().getEntities().getUrl().getUrls().get(0).getExpanded_url());
		urls.add(tweetDetail.getUser().getEntities().getUrl().getUrls().get(0).getUrl());
		response.setUrls(urls);
		return response;
	}

	public GetAllUrlsPresentResponse TranfomeGetAllUrls(TweetDetails tweetDetail) {
		GetAllUrlsPresentResponse response = new GetAllUrlsPresentResponse();
		response.setId(tweetDetail.getUser().getId());
		List<String> urls = new ArrayList<>();
		// user
		if (tweetDetail.getUser() != null) {
			urls.add(tweetDetail.getUser().getProfile_background_image_url());
			urls.add(tweetDetail.getUser().getProfile_background_image_url_https());
			urls.add(tweetDetail.getUser().getProfile_image_url_https());
			urls.add(tweetDetail.getUser().getProfile_image_url());
			urls.add(tweetDetail.getUser().getUrl());
		}
		// user entities
		if (tweetDetail.getUser().getEntities() != null && tweetDetail.getUser().getEntities().getUrl() != null && tweetDetail.getUser().getEntities().getUrl().getUrls()!=null && tweetDetail.getUser().getEntities().getUrl().getUrls().size()>0){
			for(Urls url: tweetDetail.getUser().getEntities().getUrl().getUrls()) {
				urls.add(url.getDisplay_url()==null?"":url.getDisplay_url());
				urls.add(url.getExpanded_url()==null?"":url.getExpanded_url());
				urls.add(url.getUrl()==null?"":url.getUrl());
			}
		}
		return response;
	}

}
