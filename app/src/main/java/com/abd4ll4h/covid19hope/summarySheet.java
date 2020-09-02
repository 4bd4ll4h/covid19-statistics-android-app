package com.abd4ll4h.covid19hope;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class summarySheet {

    @SerializedName("Global")
    private Global global;

    @SerializedName("Countries")
    private List<Status> Countries;

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Status> getCountries() {
        return Countries;
    }

    public void setCountries(List<Status> countries) {
        Countries = countries;
    }
}
