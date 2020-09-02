package com.abd4ll4h.covid19hope;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class network {
    Retrofit opariton;
    retrofitMethods methods;

    public network() {
        opariton =new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        methods=opariton.create(retrofitMethods.class);
    }

    public void countries(Callback<List<Country>>callback){
        Call<List<Country>>getSummary=methods.countriees();
        getSummary.enqueue(callback);
    }
    public void summary(Callback<summarySheet>callback){
        Call<summarySheet>sheetCall=methods.summary();
        if(callback!=null)sheetCall.enqueue(callback);
    }
}
