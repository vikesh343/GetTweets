package com.tweets.jsonmodel;

import java.util.List;

import lombok.Data;
@Data
public class BoundingBox {
	private String type;

	private List<List<List<String>>> coordinates;
	
	
	
}
