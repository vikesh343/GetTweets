package com.algoworks.tweets.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.algoworks.tweets.dto.TweetDetails;
import com.algoworks.tweets.response.ApplicationError;
import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UserDetailsResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;
import com.algoworks.tweets.util.ApplicationConstants;

@Component
public class TweetTransformer {

	public TweetsDetailResponse transformGetAllTweets(TweetDetails tweetDetail) {
		TweetsDetailResponse allTweetsDetails = new TweetsDetailResponse();
		allTweetsDetails.setId(((Long)tweetDetail.getTweetId()).toString());
		allTweetsDetails.setCreatedAt(tweetDetail.getCreatedAt());
		allTweetsDetails.setText(tweetDetail.getText());
		return allTweetsDetails;
	}

	public UsersDetailsResponse transformGetAllUserDetails(TweetDetails tweetDetail) {
		UsersDetailsResponse userDetails = new UsersDetailsResponse();
		userDetails.setId(tweetDetail.getUser().getId());
		userDetails.setName(tweetDetail.getUser().getName());
		userDetails.setUserName(tweetDetail.getUser().getScreenName());
		userDetails.setCreatedOn(tweetDetail.getUser().getUserCreatedAt());
		userDetails.setDescription(tweetDetail.getUser().getDescription());
		userDetails.setLocation(tweetDetail.getUser().getLocation());
		userDetails.setTimeZone(tweetDetail.getUser().getTimeZone());
		return userDetails;
	}

	public TweetDetailsResponse getTweetDetailsForID(TweetDetails tweetDetail) {
		TweetDetailsResponse getTweetDetails = new TweetDetailsResponse();
		ApplicationError error = new ApplicationError();
		TweetsDetailResponse getTweet = new TweetsDetailResponse();
		error.setErrorCode(ApplicationConstants.ERROR_CODE_SUCCESS);
		error.setErrorDescription(ApplicationConstants.SUCCESS);
		getTweet.setId(((Long)tweetDetail.getUser().getId()).toString());
		getTweet.setName(tweetDetail.getUser().getName());
		getTweet.setScreenName(tweetDetail.getUser().getScreenName());
		getTweet.setText(tweetDetail.getText());
		getTweet.setRetweetCount(tweetDetail.getRetweetCount());
		getTweet.setCreatedAt(tweetDetail.getCreatedAt());
		getTweetDetails.setApplicationError(error);
		getTweetDetails.setTweetDetails(getTweet);;
		return getTweetDetails;
	}

	public TweetDetailsResponse getTweetDetailsForIDError() {
		TweetDetailsResponse getTweetDetails = new TweetDetailsResponse();
		ApplicationError error = new ApplicationError();
		error.setErrorCode(ApplicationConstants.ERROR_CODE);
		error.setErrorDescription(ApplicationConstants.INVALID_TWEET_ID);
		getTweetDetails.setApplicationError(error);
		return getTweetDetails;
	}

	public UserDetailsResponse getUserDetailsForUser(TweetDetails tweetDetail) {
		UserDetailsResponse userDetails = new UserDetailsResponse();
		ApplicationError error = new ApplicationError();
		UsersDetailsResponse user = new UsersDetailsResponse();
		user.setId(tweetDetail.getUser().getId());
		user.setName(tweetDetail.getUser().getName());
		user.setUserName(tweetDetail.getUser().getScreenName());
		user.setCreatedOn(tweetDetail.getUser().getUserCreatedAt());
		user.setDescription(tweetDetail.getUser().getDescription());
		user.setLocation(tweetDetail.getUser().getLocation());
		user.setTimeZone(tweetDetail.getUser().getTimeZone());
		error.setErrorCode(ApplicationConstants.ERROR_CODE_SUCCESS);
		error.setErrorDescription(ApplicationConstants.SUCCESS);
		
		userDetails.setApplicationError(error);
		userDetails.setUserDetails(user);
		return userDetails;
	}

	public UserDetailsResponse getTweetDetailsForUserError() {
		UserDetailsResponse getTweetDetails = new UserDetailsResponse();
		ApplicationError error = new ApplicationError();
		error.setErrorCode(ApplicationConstants.ERROR_CODE);
		error.setErrorDescription(ApplicationConstants.INVALID_USER);
		getTweetDetails.setApplicationError(error);
		return getTweetDetails;
	}

	public Map<Long, Links> getAllUrlsTranfomer(List<TweetDetails> tweets) {
		Map<Long, Links> response = new HashMap<>();
		for (TweetDetails tweet : tweets) {
			Links links = new Links(tweet.getUser().getProfileBackgroundImageUrl(),
					tweet.getUser().getProfileBackgroundImageUrlHttps(), tweet.getUser().getProfileBannerUrl(),
					tweet.getUser().getProfileImageUrl(), tweet.getUser().getProfileImageUrlHttps(),
					tweet.getUser().getUserUrl(),
					tweet.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityUrl(),
					tweet.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityExpandedUrl(),
					tweet.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityDisplayUrl());
			response.put(tweet.getUser().getId(), links);
		}
		return response;
	}

}
