package com.abd4ll4h.covid19hope;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;
import static com.abd4ll4h.covid19hope.MainActivity.GLOBAL;
import static com.abd4ll4h.covid19hope.MainActivity.Info;

public class BasicWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Info =context.getSharedPreferences("package "+context.getPackageName(),MODE_PRIVATE);

        for(int widgetId:appWidgetIds){

            String country=Info.getString(widgetId+"a","null");
            setRemotView(country,context,widgetId);
        }
    }
    private void setRemotView(String country,Context context,int widgetId) {
        RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.widget_basic);
        AppExecutors.getInstance().networkIO().execute(()->{
            repository repos=new repository((Application) context.getApplicationContext());
            Status status=repos.getDashbord(null,country);
            while (status==null){status=repos.getDashbord(null,country);}
            remoteViews.setTextViewText(R.id.num1,bindingAdapter.format(status.getTotalRecovered()));
            remoteViews.setTextViewText(R.id.country,status.getCountry());
            remoteViews.setInt(R.id.countryImg,"setImageResource",bindingAdapter.loadFlag(country,context));
            Gson gson = new Gson();
            Global global=gson.fromJson(Info.getString(GLOBAL, null), Global.class);
            remoteViews.setTextViewText(R.id.num2,bindingAdapter.format(global.getTotalRecovered()));
            AppWidgetManager.getInstance(context).updateAppWidget(widgetId,remoteViews);

        });
    }


}
