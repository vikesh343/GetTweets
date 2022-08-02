
package com.tweets.model;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class BoundingBox {

    private String type;
    private List<List<List<Float>>> coordinates = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<List<Float>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<Float>>> coordinates) {
        this.coordinates = coordinates;
    }

}
