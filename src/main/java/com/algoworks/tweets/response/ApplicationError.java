package com.algoworks.tweets.response;

import lombok.Data;

@Data
public class ApplicationError {
	private String errorDescription;
	private String errorCode;
}
