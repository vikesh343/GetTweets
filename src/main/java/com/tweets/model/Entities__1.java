
package com.tweets.model;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Entities__1 {

    private List<Hashtag> hashtags = null;
    private List<Url__2> urls = null;
    private List<UserMention> userMentions = null;
    private List<Medium> media = null;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Url__2> getUrls() {
        return urls;
    }

    public void setUrls(List<Url__2> urls) {
        this.urls = urls;
    }

    public List<UserMention> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<UserMention> userMentions) {
        this.userMentions = userMentions;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

}
