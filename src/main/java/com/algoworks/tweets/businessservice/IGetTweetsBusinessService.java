package com.algoworks.tweets.businessservice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.UserDetailsResponse;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;
@Component
public interface IGetTweetsBusinessService {

	List<TweetsDetailResponse> getAllTweetsDetails();

	List<UsersDetailsResponse> getAllUserDetails();

	Map<Long, Links> getAllUrlsPresent();

	TweetDetailsResponse getTweetDetailsByID(long id);

	UserDetailsResponse getUserDetailsByScreenName(String screenName);

}
