package com.tweets.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.algoworks.tweets.businessservice.ITweetBusinessService;
import com.algoworks.tweets.controller.TweetsController;
import com.tweets.TweetFactory;

public class ControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ITweetBusinessService businessService;

	@InjectMocks
	private TweetsController tweetsController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(tweetsController).build();
	}

	@Test
	public void testHealthCheck() {
		TweetsController controller = new TweetsController();
		assertEquals("OK", controller.healthCheck());
	}

	@Test
	public void testGetAllTweets() throws Exception {
		Mockito.when(businessService.getAllTweetsDetails()).thenReturn(TweetFactory.getAllTweetsDetailResponse());
		mockMvc.perform(get("/algoworks/api/v1/tweet")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is("311975360667459585")))
				.andExpect(jsonPath("$[0].createdAt", is("Wed Mar 13 23:01:36 +0000 2013")));
	}

	@Test
	public void testGetUsersDetails() throws Exception {
		Mockito.when(businessService.getAllUserDetails()).thenReturn(TweetFactory.getAllUsersDetailsResponses());
		mockMvc.perform(get("/algoworks/api/v1/user")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(2384071))).andExpect(jsonPath("$[0].location", is("Sebastopol, CA")));

	}

	@Test
	public void testgetAllUrls() throws Exception {
		Mockito.when(businessService.getAllUrlsPresent()).thenReturn(TweetFactory.getAllUrls());
		mockMvc.perform(get("/algoworks/api/v1/urls")).andExpect(status().isOk());
	}

	@Test
	public void testGetUserByScreenName() throws Exception {
		Mockito.when(businessService.getUserDetailsByScreenName(Mockito.any()))
				.thenReturn(TweetFactory.getUserDetails());
		mockMvc.perform(get("/algoworks/api/v1/user/{screenName}", "timoreilly")).andExpect(status().isOk())
				.andExpect(jsonPath("$.applicationError.errorCode", notNullValue()))
				.andExpect(jsonPath("$.userDetails.id", is(2384071)));
	}

	@Test
	public void testGetTweetByID() throws Exception {
		Mockito.when(businessService.getTweetDetailsByID(311975360667459585L))
				.thenReturn(TweetFactory.getTweetDetailsResponse());
		mockMvc.perform(get("/algoworks/api/v1/tweet/{id}", 311975360667459585L)).andExpect(status().isOk())
				.andExpect(jsonPath("$.applicationError", notNullValue()))
				.andExpect(jsonPath("$.tweetDetails.id", is("311975360667459585")));
	}

}
