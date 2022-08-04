package com.algoworks.tweets.response;

import lombok.Data;
@Data
public class UserDetailsResponse {
	private ApplicationError applicationError;
	private UsersDetailsResponse userDetails;
}
