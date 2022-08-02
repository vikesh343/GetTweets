
package com.tweets.model;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Coordinates {

    private String type;
    private List<Float> coordinates = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }

}
