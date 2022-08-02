package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class UserMentions {
	private String screen_name;
	private String name;
	private String id;
	private String id_str;
	private List<String> indices;
}
