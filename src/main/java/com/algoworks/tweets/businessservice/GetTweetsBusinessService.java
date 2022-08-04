package com.algoworks.tweets.businessservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algoworks.tweets.dto.TweetDetails;
import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.UserDetailsResponse;
import com.algoworks.tweets.transform.TweetTransformer;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;
import com.algoworks.tweets.util.Utility;

@Component
public class GetTweetsBusinessService implements IGetTweetsBusinessService {

	@Autowired
	TweetTransformer tranformer;

	@Autowired
	Utility util;

	@Override
	public List<TweetsDetailResponse> getAllTweetsDetails() {
		List<TweetsDetailResponse> tweet = new ArrayList<>();
		List<TweetDetails> tweets = util.jsonReader();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				tweet.add(tranformer.transformGetAllTweets(tweetDetail));
			}
		}
		return tweet;
	}

	@Override
	public List<UsersDetailsResponse> getAllUserDetails() {
		List<UsersDetailsResponse> userDetails = new ArrayList<>();
		List<TweetDetails> tweets = util.jsonReader();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				userDetails.add(tranformer.transformGetAllUserDetails(tweetDetail));
			}
		}
		return userDetails;
	}

	@Override
	public Map<Long, Links> getAllUrlsPresent() {
		Map<Long, Links> urls = new HashMap<>();
		List<TweetDetails> tweets = util.jsonReader();
		if (tweets != null && !tweets.isEmpty()) {
			urls = tranformer.getAllUrlsTranfomer(tweets);
		}
		return urls;
	}

	@Override
	public TweetDetailsResponse getTweetDetailsByID(long id) {
		TweetDetailsResponse getTweetForID = null;
		List<TweetDetails> tweets = util.jsonReader();
		if (tweets != null && !tweets.isEmpty()){
			for (TweetDetails tweetDetail : tweets) {
				if (tweetDetail.getTweetId()==id) {
					getTweetForID = tranformer.getTweetDetailsForID(tweetDetail);
					break;
				}
			}
			if (getTweetForID == null) {
				getTweetForID = tranformer.getTweetDetailsForIDError();
			}
		}
		return getTweetForID;
	}

	@Override
	public UserDetailsResponse getUserDetailsByScreenName(String screenName) {
		UserDetailsResponse getTweetForUser = null;
		List<TweetDetails> tweets = util.jsonReader();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				if (tweetDetail.getUser().getScreenName().equals(screenName)) {
					getTweetForUser = tranformer.getUserDetailsForUser(tweetDetail);
					break;
				}
			}
			if (getTweetForUser == null) {
				getTweetForUser = tranformer.getTweetDetailsForUserError();
			}
		}
		return getTweetForUser;
	}

}
