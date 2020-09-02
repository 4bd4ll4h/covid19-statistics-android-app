package com.abd4ll4h.covid19hope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.abd4ll4h.covid19hope.databinding.DetailsFragmentBinding;

import static com.abd4ll4h.covid19hope.bindingAdapter.loadFlag;


public class Details extends Fragment {

    DetailsFragmentBinding binding;
    String country;
    private DetailsViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        country = DetailsArgs.fromBundle(getArguments()).getId();

        mViewModel = ViewModelProviders.of(this, new DetailFactory(country, getActivity().getApplication())).get(DetailsViewModel.class);

        binding = DetailsFragmentBinding.inflate(inflater, container, false);

        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(mViewModel.countr.get().getCountry());
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.setStatu(mViewModel);


        // TODO: Use the ViewModel
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.detail, menu);

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem flagImg = menu.findItem(R.id.flag);
        flagImg.setIcon(loadFlag(mViewModel.id,getContext()));

    }



}
