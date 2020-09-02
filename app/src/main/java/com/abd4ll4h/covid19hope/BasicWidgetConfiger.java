package com.abd4ll4h.covid19hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.abd4ll4h.covid19hope.MainActivity.COUNTIES;
import static com.abd4ll4h.covid19hope.MainActivity.GLOBAL;
import static com.abd4ll4h.covid19hope.MainActivity.Info;

public class BasicWidgetConfiger extends AppCompatActivity {

    ListView listView;
    countryAdapter countryAdapter;
    int widgetId=AppWidgetManager.INVALID_APPWIDGET_ID;
    Intent res;
    private CountriesViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_widget_configer);

        Intent config =getIntent();
        Bundle extras=config.getExtras();
        TelephonyManager tm = (TelephonyManager)getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        assert tm != null;
        String countryCode = tm.getNetworkCountryIso();
        if (extras!=null){
            widgetId=extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

        }
         res=new Intent();
        res.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,widgetId);
        assert countryCode != null;
        res.putExtra("countryId",countryCode);
        setResult(RESULT_CANCELED,res);

        if(widgetId==AppWidgetManager.INVALID_APPWIDGET_ID)finish();


        mViewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);


        listView=findViewById(R.id.counties_listWidget);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.i("countryId",countryAdapter.getItem(position).getId());

            setRemotView(countryAdapter.getItem(position).getId());


        });
        countryAdapter=new countryAdapter(getApplicationContext(),R.layout.counteries_list_item,new ArrayList<>());

        mViewModel.var.getCountries().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {

                countryAdapter=new countryAdapter(getApplicationContext(),R.layout.counteries_list_item,countries);
                listView.setAdapter(countryAdapter);

            }
        } );

    }

    private void setRemotView(String country) {
        Info =getSharedPreferences("package "+getPackageName(),MODE_PRIVATE);
        Info.edit().putString(widgetId+"a",country).apply();
        res.putExtra("countryId",country);
        setResult(RESULT_OK,res);
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.widget_basic);
        Log.i("countryId","recovered: ");
        AppExecutors.getInstance().networkIO().execute(()->{
            repository repos=new repository(getApplication());
            Status status=repos.getDashbord(null,country);
            while (status==null){status=repos.getDashbord(null,country);}

            remoteViews.setTextViewText(R.id.country,status.getCountry());
            remoteViews.setTextViewText(R.id.num1,bindingAdapter.format(status.getTotalRecovered()));
            remoteViews.setInt(R.id.countryImg,"setImageResource",bindingAdapter.loadFlag(country,getApplicationContext()));
            Gson gson = new Gson();

            Global global=gson.fromJson(Info.getString(GLOBAL, null), Global.class);
            Log.i("countryId","recovered: "+global.getTotalRecovered());

            remoteViews.setTextViewText(R.id.num2,bindingAdapter.format(global.getTotalRecovered()));
            AppWidgetManager.getInstance(getApplicationContext()).updateAppWidget(widgetId,remoteViews);

            finish();
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.country_menu,menu);
        return true;

    }

    @Override
    public boolean onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem searchItem=menu.findItem(R.id.country_search);
        SearchView searchView= (SearchView) searchItem.getActionView();
        Log.i("443ssss","here");
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("443ssss",newText);
                countryAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
