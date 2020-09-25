
package com.ujjwalsingh.fampay.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormattedDescription {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("entities")
    @Expose
    private List<Entity> entities = null;
    @SerializedName("align")
    @Expose
    private String align;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

}
