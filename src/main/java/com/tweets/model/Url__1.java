package com.tweets.model;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Url__1 {

    private String url;
    private Object expandedUrl;
    private List<Integer> indices = null;
    private String displayUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(Object expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

}
