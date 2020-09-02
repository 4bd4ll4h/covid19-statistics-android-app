package com.abd4ll4h.covid19hope;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class Country {

    @ColumnInfo
    @SerializedName("Country")
    private String country;
    @ColumnInfo
    private String Slug;
    @ColumnInfo
    @PrimaryKey
    @NonNull
    @SerializedName(value = "ISO2",alternate = "CountryCode")
    private String id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
