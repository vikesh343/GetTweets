package com.algoworks.tweets.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Links {
	private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private String profileBannerUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String url;
    private String userEntityUrlUrlsUrl;
    private String userEntityUrlUrlsExpandedUrl;
    private String userEntityUrlUrlsDisplayUrl;
}
