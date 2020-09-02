package com.abd4ll4h.covid19hope;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abd4ll4h.covid19hope.databinding.CardBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.abd4ll4h.covid19hope.MainActivity.COUNTIES;
import static com.abd4ll4h.covid19hope.MainActivity.Info;
import static com.abd4ll4h.covid19hope.ui.main.MainFragment.setListViewHeightBasedOnItems;

public class listViewAdapter extends ArrayAdapter<Status> implements Filterable {

    public CardBinding cardBinding;
    Status status;
    ListView listView;
    int i;
    private List<Status> filter;
    private Filter cardFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Status> filterdList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0)
                filterdList.addAll(filter);
            else {
                String filterPartten = constraint.toString().toLowerCase().trim();
                for (Status status : filter) {
                    if (status.getCountry().toLowerCase().contains(filterPartten)
                            || status.getId().toLowerCase().contains(filterPartten))
                        filterdList.add(status);
                }
            }

            FilterResults Results = new FilterResults();
            Results.values = filterdList;


            return Results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {


            clear();

            notifyDataSetChanged();
            addAll((List) results.values);
            clear();
            addAll((List) results.values);

            notifyDataSetChanged();
        }
    };



    public listViewAdapter(@NonNull Context context, int resource, @NonNull List<Status> objects, ListView listView) {
        super(context, resource, objects);
        this.filter = new ArrayList<>(objects);
        this.listView=listView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        i = 0;
        status = getItem(position);
        cardBinding = CardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        cardBinding.setItem(getItem(position));
        cardBinding.spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<String> list = new HashSet<>(Info.getStringSet(COUNTIES, new HashSet<>()));
                list.remove(status.getId());
                Info.edit().putStringSet(COUNTIES,  list).apply();
                remove(status);
                notifyDataSetChanged();

            }
        });
        return cardBinding.getRoot();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return cardFilter;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        setListViewHeightBasedOnItems(listView);

    }
}
