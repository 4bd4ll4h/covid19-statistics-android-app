package com.abd4ll4h.covid19hope;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.abd4ll4h.covid19hope.databinding.CountriesFragmentBinding;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.abd4ll4h.covid19hope.MainActivity.COUNTIES;
import static com.abd4ll4h.covid19hope.MainActivity.Info;

public class Countries extends Fragment {
    countryAdapter countryAdapter;
    CountriesFragmentBinding binding;
    private CountriesViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mViewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= CountriesFragmentBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.countiesList.setOnItemClickListener((parent, view, position, id) -> {

            Set<String> set=Info.getStringSet(COUNTIES,new HashSet<String>());
            set.add(mViewModel.var.getCountries().getValue().get((int) id).getId());
            Info.edit().putStringSet(COUNTIES,set).apply();
            Navigation.findNavController(view).popBackStack();

        });

        mViewModel.var.getCountries().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {

                    countryAdapter=new countryAdapter(getContext(),R.layout.counteries_list_item,countries);
                binding.countiesList.setAdapter(countryAdapter);

            }
        } );
        // TODO: Use the ViewModel
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.country_menu,menu);

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
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
    }
}
