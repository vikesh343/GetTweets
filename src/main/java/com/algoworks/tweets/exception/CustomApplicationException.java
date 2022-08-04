package com.algoworks.tweets.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomApplicationException extends RuntimeException {

	public CustomApplicationException(String errorMessage) {
		super(errorMessage);
	}
}
