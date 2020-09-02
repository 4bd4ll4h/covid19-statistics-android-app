package com.abd4ll4h.covid19hope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.abd4ll4h.covid19hope.ui.main.MainFragment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public  class  MainActivity extends AppCompatActivity {
    public static final String COUNTIES = "Countries",GLOBAL="Global";
    public static  SharedPreferences Info;
    public static HashMap<String,String >unicodeMap=new HashMap<>();
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    public static synchronized void loadFlags(Context context){
        AppExecutors.getInstance().networkIO().execute(()-> {
            List<flagsUnicode> unicodes=new ArrayList<>();

            if (unicodes.isEmpty()) {
                try {

                    InputStream input = context.getAssets().open("flag_unicodes.json");
                    JsonReader reader = new JsonReader(new InputStreamReader(input));
                    Type plantType = new TypeToken<List<flagsUnicode>>() {}.getType();
                    unicodes = new Gson().fromJson(reader, plantType);
                    Log.i("4431","sss"+unicodes.size());
                    input.close();
                } catch (Exception ignored) { }
            }
            unicodeMap=new HashMap<>();
            for (flagsUnicode flag:unicodes){

                unicodeMap.put(flag.getId(),flag.getUnicode().toLowerCase() );
            }
            Log.i("4431","sss"+unicodes.size());



        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Info =getSharedPreferences("package "+getPackageName(),MODE_PRIVATE);
        this.navController = Navigation.findNavController(this, R.id.container);
        this.appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        loadFlags(getApplicationContext());
        if (!Info.contains(COUNTIES)){
        TelephonyManager tm = (TelephonyManager)getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        String countryCode = tm.getNetworkCountryIso();
            Set<String >set= new HashSet<>();
            set.add(countryCode.toUpperCase());
        Info.edit().putStringSet(COUNTIES,set).apply();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }
}
