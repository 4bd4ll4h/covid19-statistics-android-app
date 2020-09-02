package com.abd4ll4h.covid19hope.ui.main;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.abd4ll4h.covid19hope.BR;
import com.abd4ll4h.covid19hope.Country;
import com.abd4ll4h.covid19hope.Global;
import com.abd4ll4h.covid19hope.Status;

import com.abd4ll4h.covid19hope.repository;
import com.abd4ll4h.covid19hope.summarySheet;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.abd4ll4h.covid19hope.MainActivity.COUNTIES;
import static com.abd4ll4h.covid19hope.MainActivity.GLOBAL;
import static com.abd4ll4h.covid19hope.MainActivity.Info;

public class MainViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    public Variable var;
    repository repository;
    Context context;
    Callback<summarySheet> callback = new Callback<summarySheet>() {
        @Override
        public void onResponse(Call<summarySheet> call, Response<summarySheet> response) {
            if (!response.isSuccessful()) {

            } else {

                repository.setSummary(response.body().getCountries());
                response.body().getGlobal().setDate(new Date().toString());
                var.setGlobal(response.body().getGlobal());
                Gson gson = new Gson();
                Info.edit().putString(GLOBAL, gson.toJson(response.body().getGlobal(), Global.class)).apply();
                Log.i("falied443", gson.toJson(response.body().getGlobal()));

            }


        }

        @Override
        public void onFailure(Call<summarySheet> call, Throwable t) {

        }
    };

    public MainViewModel(@Nullable Application application) {
        super(application);
        repository = new repository(application);
        var = new Variable();
        this.context = application.getApplicationContext();

    }

    public void getSummary() {
        Gson gson = new Gson();
        List<String> list = new ArrayList<>(Info.getStringSet(COUNTIES, new HashSet<>()));

        Log.i("443","list size: "+list.size()+list.get(0));
        var.setSummayData(repository.getSummary(callback, list));
        if(Info.contains(GLOBAL))
        var.setGlobal(gson.fromJson(Info.getString(GLOBAL, null), Global.class));
        else var.setGlobal(new Global(new Date().toString()));

    }

    public class Variable extends BaseObservable {

        private String country;
        private LiveData<List<Status>> summayData;
        private ObservableField<Global> global=new ObservableField<>();


        @Bindable
        public ObservableField<Global> getGlobal() {
            return global;
        }



        public void setGlobal(Global global) {
            this.global.set( global);
            notifyPropertyChanged(com.abd4ll4h.covid19hope.BR.item);
            Log.i("443u","updated" );
        }

        @Bindable
        public LiveData<List<Status>> getSummayData() {
            return summayData;
        }




        public void setSummayData(LiveData<List<Status>> summayData) {
            this.summayData = summayData;
            notifyPropertyChanged(BR.item);
        }

        @Bindable
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
            notifyPropertyChanged(com.abd4ll4h.covid19hope.BR.country);
        }
    }


}
