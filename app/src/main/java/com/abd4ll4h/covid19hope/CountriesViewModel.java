package com.abd4ll4h.covid19hope;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesViewModel extends AndroidViewModel {
    repository repository;
    variable var;
   Callback<List<Country>>callback= new Callback<List<Country>>() {
        @Override
        public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

            if (!response.isSuccessful()){

            }else {
                var.setCountries(response.body());
                Log.i("443s",response.code()+response.message());
            }
        }

        @Override
        public void onFailure(Call<List<Country>> call, Throwable t) {

        }
    };

    public CountriesViewModel(@NonNull Application application) {
        super(application);
        repository=new repository(application);
        var=new variable();
        repository.getCountries(callback);

    }

    public class variable extends BaseObservable {
        private MutableLiveData<List<Country>>countries=new MutableLiveData<>();


        @Bindable
        public LiveData<List<Country>> getCountries() {
            return countries;
        }

        public void setCountries(List<Country> countries) {

                this.countries.setValue(countries);

            notifyPropertyChanged(BR.list);


        }
    }

    // TODO: Implement the ViewModel
}
