package com.tweets.util;

import lombok.Data;

@Data
public class ApplicationError {
	private String errorDescription;
	private String errorCode;
}
