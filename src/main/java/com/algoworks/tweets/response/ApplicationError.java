package com.algoworks.tweets.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationError {
	private String errorDescription;
	private String errorCode;
}
