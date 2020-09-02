package com.abd4ll4h.covid19hope;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class repository {
    Application application;
    private network network;
    private DB db;
    private dao db_op;
    public repository(Application application)
    {
        db_op=DB.getInstance(application).dao();
        network= new network();
        this.application=application;
    }

    public void getCountries(Callback<List<Country>> callback){
        network.countries(callback);
    }

    public LiveData<List<Status>> getSummary(Callback<summarySheet>callback, List<String>ids){
        network.summary(callback);
        return db_op.getSummary(ids.toArray(new String[0]));
    }

    public void setSummary(final List<Status> countries1) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                db_op.setSummary(countries1);

                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(application.getApplicationContext());
                int appWidgetIds[] = appWidgetManager.getAppWidgetIds(
                        new ComponentName(application.getApplicationContext(), BasicWidget.class));
                appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds,R.layout.widget_basic);
            }
        });
    }

    public Status getDashbord(Callback<summarySheet>callback, String id){
        network.summary(callback);
        return db_op.getDashbord(id);
    }
}
