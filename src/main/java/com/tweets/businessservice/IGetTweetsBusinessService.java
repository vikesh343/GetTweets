package com.tweets.businessservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tweets.response.getalltweets.AllTweetsDetails;
import com.tweets.response.getallurls.GetAllUrlsPresentResponse;
import com.tweets.response.gettweetforid.GetTweetForID;
import com.tweets.response.gettweetforuser.GetTweetForUser;
import com.tweets.response.getuserdetails.UserDetails;
@Component
public interface IGetTweetsBusinessService {

	List<AllTweetsDetails> getAllTweetsDetails();

	List<UserDetails> getAllUserDetails();

	List<GetAllUrlsPresentResponse> getAllUrlsPresent();

	GetTweetForID getTweetDetailsForID(String id);

	GetTweetForUser getTweetDetailsForUser(String user);

}
