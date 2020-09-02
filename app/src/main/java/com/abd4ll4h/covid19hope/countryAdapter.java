package com.abd4ll4h.covid19hope;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abd4ll4h.covid19hope.databinding.CounteriesListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class countryAdapter extends ArrayAdapter<Country> implements Filterable {
    public CounteriesListItemBinding binding;
    List<Country>filter;
    private Filter cardFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country>filterdList=new ArrayList<>();
            if(constraint==null||constraint.length()==0)
                filterdList.addAll(filter);
            else {
                String filterPartten=constraint.toString().toLowerCase().trim();
                for (Country status:filter){
                    if(status.getCountry().toLowerCase().contains(filterPartten)
                            ||status.getId().toLowerCase().contains(filterPartten))
                        filterdList.add(status);
                }
            }
            FilterResults Results=new FilterResults();
            Results.values=filterdList;
            Log.i("443ssss",filterdList.size()+"size");

            return Results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            clear();
            addAll((List)results.values);
        }
    };

    public countryAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
        filter=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        binding=CounteriesListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        binding.setList(getItem(position));
        return binding.getRoot();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return cardFilter;
    }
}
