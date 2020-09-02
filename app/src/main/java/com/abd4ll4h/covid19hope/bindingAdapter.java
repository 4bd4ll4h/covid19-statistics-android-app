package com.abd4ll4h.covid19hope;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.NumberFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static com.abd4ll4h.covid19hope.MainActivity.loadFlags;
import static com.abd4ll4h.covid19hope.MainActivity.unicodeMap;


public class bindingAdapter {
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    @BindingAdapter("loadFlag")
    public static void loadFlag(ImageView view, String country) {
        if (unicodeMap == null || unicodeMap.isEmpty())
        {            loadFlags(view.getContext().getApplicationContext());}
        Log.i("4431f",country+":"+unicodeMap.get(country+", flag")+unicodeMap.size());

        try {
            int r=getResourceID("ic_"+unicodeMap.get(country+", flag").split("-")[0]+"_"
                    +unicodeMap.get(country+", flag").split("-")[1],view.getContext().getApplicationContext());
            view.setImageResource(r);
        }catch (Exception e){
            view.setImageResource(R.drawable.ic_1f30d_africa_europe);
        }



    }

    public static int loadFlag( String country,Context context) {
        if (unicodeMap == null || unicodeMap.isEmpty())
        {            loadFlags(context.getApplicationContext());}
        int r;
        Log.i("4431f",country+":"+unicodeMap.get(country+", flag")+unicodeMap.size());

        try {
             r=getResourceID("ic_"+unicodeMap.get(country+", flag").split("-")[0]+"_"
                    +unicodeMap.get(country+", flag").split("-")[1],context);

        }catch (Exception e){
            r=R.drawable.ic_1f30d_africa_europe;
        }

        return r;


    }

    @BindingAdapter("covertNumber")
    public static void convertText(TextView view, long number) {
        view.setText(format(number));
    }

    @BindingAdapter("dateFormat")
    public static void dateFormat(TextView view, String date) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM dd,yyyy");


        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date1 = inputFormat.parse(date);
            String formattedDate = dateFormat.format(date1);
            view.setText(String.format("last Update .%s", formattedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @BindingAdapter("healthNumberConverter")
    public static void healthNumberConverter(TextView view, long num) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        view.setText(numberFormat.format(num));

    }

    @BindingAdapter("IsVisable")
    public static void IsVisable(View view, Boolean bool) {
        if(bool!=null)
        view.setVisibility(bool ? View.VISIBLE : View.GONE);
    }

    public static String format(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? NumFormat(truncated / 10d) + suffix : NumFormat(truncated / 10) + suffix;
    }

    public static String NumFormat(double val) {

        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(val);
    }

    public static int getResourceID(final String resName, final Context ctx) {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, "drawable",
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        } else {
            return ResourceID;

        }
    }
}
