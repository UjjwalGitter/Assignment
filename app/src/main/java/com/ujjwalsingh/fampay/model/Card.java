
package com.ujjwalsingh.fampay.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("formatted_title")
    @Expose
    private FormattedTitle formattedTitle;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("formatted_description")
    @Expose
    private FormattedDescription formattedDescription;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bg_image")
    @Expose
    private BgImage bgImage;
    @SerializedName("bg_color")
    @Expose
    private String bgColor;
    @SerializedName("cta")
    @Expose
    private List<Button_CTA> cta = null;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("bg_gradient")
    @Expose
    private BgGradient bgGradient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FormattedTitle getFormattedTitle() {
        return formattedTitle;
    }

    public void setFormattedTitle(FormattedTitle formattedTitle) {
        this.formattedTitle = formattedTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FormattedDescription getFormattedDescription() {
        return formattedDescription;
    }

    public void setFormattedDescription(FormattedDescription formattedDescription) {
        this.formattedDescription = formattedDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BgImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<Button_CTA> getCta() {
        return cta;
    }

    public void setCta(List<Button_CTA> cta) {
        this.cta = cta;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public BgGradient getBgGradient() {
        return bgGradient;
    }

    public void setBgGradient(BgGradient bgGradient) {
        this.bgGradient = bgGradient;
    }

}
