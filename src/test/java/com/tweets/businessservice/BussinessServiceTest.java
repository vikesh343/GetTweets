package com.tweets.businessservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.algoworks.tweets.businessservice.ITweetBusinessService;
import com.algoworks.tweets.businessservice.TweetBusinessService;
import com.algoworks.tweets.dto.TweetDetails;
import com.algoworks.tweets.response.Links;
import com.algoworks.tweets.response.TweetDetailsResponse;
import com.algoworks.tweets.response.TweetsDetailResponse;
import com.algoworks.tweets.response.UserDetailsResponse;
import com.algoworks.tweets.response.UsersDetailsResponse;
import com.algoworks.tweets.transform.TweetTransformer;
import com.algoworks.tweets.util.Utility;
import com.tweets.TweetFactory;

public class BussinessServiceTest {
	@InjectMocks
	ITweetBusinessService businessService;
	@Mock
	TweetTransformer transformer;
	@Mock
	Utility util;
	
	
	
	@BeforeEach
	public void setup() {
		businessService = new TweetBusinessService();
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void getAllTweetsDetailsTest() {
		Mockito.when(util.jsonReader()).thenReturn(TweetFactory.getTweetDetails());
		Mockito.when(transformer.transformGetAllTweets(Mockito.any())).thenReturn(TweetFactory.getTweetsDetails());
		List<TweetsDetailResponse> response = businessService.getAllTweetsDetails();
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response).asString().contains("311975360667459585");
	}
	
	@Test
	public void getAllUserDetailsTest() {
		Mockito.when(util.jsonReader()).thenReturn(TweetFactory.getTweetDetails());
		Mockito.when(transformer.transformGetAllUserDetails(Mockito.any())).thenReturn(TweetFactory.getUsersDetails());
		List<UsersDetailsResponse> response = businessService.getAllUserDetails();
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.get(0)).asString().contains("timoreilly");
		
	}
	
	@Test
	public void getTweetsDetailsTestByID() {
		Mockito.when(util.jsonReader()).thenReturn(TweetFactory.getTweetDetails());
		Mockito.when(transformer.getTweetDetailsForID(Mockito.any(TweetDetails.class))).thenReturn(TweetFactory.getTweetDetailsResponse());
		TweetDetailsResponse response = businessService.getTweetDetailsByID(311975360667459585L);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getTweetDetails().getId().equals("311975360667459585"));
	}
	
	@Test 
	public void getUserDetailsByScreenName() {
		Mockito.when(util.jsonReader()).thenReturn(TweetFactory.getTweetDetails());
		Mockito.when(transformer.getUserDetailsForUser(Mockito.any())).thenReturn(TweetFactory.getUserDetails());
		UserDetailsResponse response = businessService.getUserDetailsByScreenName("timoreilly");
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getUserDetails().getUserName().equals("timoreilly"));
	}
	
	@Test
	public void getUrlsTest() {
		Mockito.when(util.jsonReader()).thenReturn(TweetFactory.getTweetDetails());
		Mockito.when(transformer.getAllUrlsTranfomer(Mockito.any())).thenReturn(TweetFactory.getAllUrls());
		Map<Long, Links> response = businessService.getAllUrlsPresent();
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response).asString().contains("http://radar.oreilly.com");
	}
	
}
