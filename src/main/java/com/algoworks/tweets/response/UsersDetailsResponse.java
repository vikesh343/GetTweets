package com.algoworks.tweets.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDetailsResponse {
	private long id;
	private String userName;
	private String location;
	private String name;
	private String description;
	private String createdOn;
	private String timeZone;
}
