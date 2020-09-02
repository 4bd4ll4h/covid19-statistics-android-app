package com.abd4ll4h.covid19hope;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface retrofitMethods {

    @GET("countries")
    Call<List<Country>> countriees();

    @GET("summary")
    Call<summarySheet> summary();



}
