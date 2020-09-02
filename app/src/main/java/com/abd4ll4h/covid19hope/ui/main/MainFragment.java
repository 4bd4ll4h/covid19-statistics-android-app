package com.abd4ll4h.covid19hope.ui.main;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.abd4ll4h.covid19hope.R;
import com.abd4ll4h.covid19hope.databinding.MainFragmentBinding;
import com.abd4ll4h.covid19hope.listViewAdapter;
import com.abd4ll4h.covid19hope.Status;

import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private listViewAdapter mAdapter;
    private MainFragmentBinding binding;

    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            Log.i("443sa",numberOfItems+"numberOFitem");
            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                float px = 500 * (listView.getResources().getDisplayMetrics().density);
                item.measure(View.MeasureSpec.makeMeasureSpec((int) px, View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);
            Log.i("443sa",totalDividersHeight+"dividers");

            // Get padding
            int totalPadding = listView.getPaddingTop() + listView.getPaddingBottom();
            Log.i("443sa",totalPadding+"pading");

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + totalPadding;
            listView.setLayoutParams(params);
            listView.requestLayout();
            //setDynamicHeight(listView);
            return true;

        } else {
            return false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getSummary();

        binding.setLifecycleOwner(getViewLifecycleOwner());
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListViewHeightBasedOnItems(binding.list);
        mViewModel.var.getSummayData().observe(getViewLifecycleOwner(), new Observer<List<Status>>() {
            @Override
            public void onChanged(List<Status> statuses) {
                if (statuses != null) {
                    mAdapter = new listViewAdapter(Objects.requireNonNull(getContext()), R.layout.card, statuses,binding.list);
                    binding.setIsEmpty(statuses.isEmpty());
                    Log.i("443", "size: " + statuses.size());
                    binding.list.setAdapter(mAdapter);
                    setListViewHeightBasedOnItems(binding.list);
                }

            }
        });


        binding.setItem(mViewModel.var);

        binding.list.setOnItemClickListener((parent, view, position, id) -> {
            NavDirections action = MainFragmentDirections.actionMainFragmentToDetails(mViewModel.var.getSummayData().getValue().get((int) id).getId());
            Navigation.findNavController(view).navigate(action);

        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections action = MainFragmentDirections.actionMainFragmentToCountries();
                Navigation.findNavController(v).navigate(action);

            }
        });

        binding.globle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections directions=MainFragmentDirections.actionMainFragmentToDetails("1");
                Navigation.findNavController(v).navigate(directions);
            }
        });
        // TODO: Use the ViewModel
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.maim_fragment_menu, menu);

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem searchItem = menu.findItem(R.id.main_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                setListViewHeightBasedOnItems(binding.list);

                return false;
            }
        });
    }
}
