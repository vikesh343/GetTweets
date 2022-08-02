package com.tweets.response.getallurls;

import java.util.List;

import lombok.Data;

@Data
public class GetAllUrlsPresentResponse {
	private String id;
	private List<String> urls;
}
