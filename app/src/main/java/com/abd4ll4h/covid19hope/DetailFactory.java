package com.abd4ll4h.covid19hope;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DetailFactory implements ViewModelProvider.Factory {

    private String id;
    private Application application;

    public DetailFactory(String id, Application application) {
        this.id = id;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)  new DetailsViewModel(this.id,this.application);
    }
}
