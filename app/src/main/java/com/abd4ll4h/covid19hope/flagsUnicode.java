package com.abd4ll4h.covid19hope;

import com.google.gson.annotations.SerializedName;

public class flagsUnicode {
    @SerializedName("Country")
    private String country;
    @SerializedName("CountryCode")
    private String id;
    @SerializedName("unicode")
    private String unicode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }
}
