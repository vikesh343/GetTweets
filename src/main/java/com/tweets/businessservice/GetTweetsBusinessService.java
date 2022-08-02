package com.tweets.businessservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweets.jsonmodel.TweetDetails;
import com.tweets.response.getalltweets.AllTweetsDetails;
import com.tweets.response.getallurls.GetAllUrlsPresentResponse;
import com.tweets.response.gettweetforid.GetTweetForID;
import com.tweets.response.gettweetforuser.GetTweetForUser;
import com.tweets.response.getuserdetails.UserDetails;
import com.tweets.transformer.TweetTransformer;
import com.tweets.util.Utility;

@Component
public class GetTweetsBusinessService implements IGetTweetsBusinessService {

	@Autowired
	TweetTransformer tranformer;

	@Autowired
	Utility util;
	

	@Override
	public List<AllTweetsDetails> getAllTweetsDetails() {
		// GetTweetsDTO dto = new GetTweetsDTO();
		List<AllTweetsDetails> tweet = new ArrayList<>();
		List<TweetDetails> tweets = util.tweetDetails();
			if (tweets != null && !tweets.isEmpty()) {
				for (TweetDetails tweetDetail : tweets) {
					tweet.add(tranformer.transformGetAllTweets(tweetDetail));
				}
			}
		return tweet;
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		List<UserDetails> userDetails = new ArrayList<>();
		List<TweetDetails> tweets = util.tweetDetails();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				userDetails.add(tranformer.transformGetAllUserDetails(tweetDetail));
			}
		}
		return userDetails;
	}

	@Override
	public List<GetAllUrlsPresentResponse> getAllUrlsPresent() {
		// TODO Auto-generated method stub
		List<GetAllUrlsPresentResponse> getAllUrl = new ArrayList<>();
		List<TweetDetails> tweets = util.tweetDetails();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				getAllUrl.add(tranformer.getAllUrlsTranfomer(tweetDetail));
				//getAllUrl.add(tranformer.TranfomeGetAllUrls(tweetDetail));
			}
		}
		return getAllUrl;
	}

	@Override
	public GetTweetForID getTweetDetailsForID(String id) {
		// TODO Auto-generated method stub
		GetTweetForID getTweetForID = null;
		List<TweetDetails> tweets = util.tweetDetails();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				if (tweetDetail.getUser().getId().equals(id)) {
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
	public GetTweetForUser getTweetDetailsForUser(String user) {
		GetTweetForUser getTweetForUser = null;
		List<TweetDetails> tweets = util.tweetDetails();
		if (tweets != null && !tweets.isEmpty()) {
			for (TweetDetails tweetDetail : tweets) {
				if (tweetDetail.getUser().getScreen_name().equals(user)) {
					getTweetForUser = tranformer.getTweetDetailsForUser(tweetDetail);
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
