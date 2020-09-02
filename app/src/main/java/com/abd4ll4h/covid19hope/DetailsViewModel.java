package com.abd4ll4h.covid19hope;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.abd4ll4h.covid19hope.MainActivity.GLOBAL;
import static com.abd4ll4h.covid19hope.MainActivity.Info;


public class DetailsViewModel extends AndroidViewModel  {
    ObservableField<Status> countr;
    repository repository;
    String id;
    private Callback<summarySheet> callBack=new Callback<summarySheet>() {
        @Override
        public void onResponse(Call<summarySheet> call, Response<summarySheet> response) {
            if (response.isSuccessful()){
                if(!id.equals("1")) {
                    for (Status status : response.body().getCountries()) {

                        if (id.equals(status.getId())) {
                            setCountr(status);
                            break;
                        }
                    }
                }else {
                    Global global=response.body().getGlobal();
                    Status status=new Status(global.getNewConfirmed(),global.getTotalConfirmed(),global.getNewDeaths(),
                            global.getTotalDeaths(),global.getNewRecovered(),global.getTotalRecovered(),global.getDate());
                    status.setCountry("Global");
                    status.setId("1");
                    countr.set(status);
                }

            }
        }

        @Override
        public void onFailure(Call<summarySheet> call, Throwable t) {

        }
    };

    public DetailsViewModel(String id,@NonNull Application application) {
        super(application);
        countr=new ObservableField<>(new Status());
        repository=new repository(application);
        AppExecutors.getInstance().diskIO().execute(()->setDashBord(id));
    }

    public void setDashBord(String country) {

        id=country;
        if(id!="1")
        countr.set(repository.getDashbord(callBack,country));
        else {
            Gson gson = new Gson();
            Global global=gson.fromJson(Info.getString(GLOBAL, null), Global.class);
            Status status=new Status(global.getNewConfirmed(),global.getTotalConfirmed(),global.getNewDeaths(),
                                        global.getTotalDeaths(),global.getNewRecovered(),global.getTotalRecovered(),global.getDate());
            status.setCountry("Global");
            status.setId("1");
            countr.set(status);
        }
    }

    public ObservableField<Status> getCountr() {
        return countr;
    }

    public void setCountr(Status countr) {
        this.countr.set(countr);

    }
}
