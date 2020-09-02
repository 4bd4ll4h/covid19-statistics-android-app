package com.abd4ll4h.covid19hope;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.abd4ll4h.covid19hope.databinding.ActivityBasicWidgetConfigerBindingImpl;
import com.abd4ll4h.covid19hope.databinding.CardBindingImpl;
import com.abd4ll4h.covid19hope.databinding.CounteriesListItemBindingImpl;
import com.abd4ll4h.covid19hope.databinding.CountriesFragmentBindingImpl;
import com.abd4ll4h.covid19hope.databinding.DetailsFragmentBindingImpl;
import com.abd4ll4h.covid19hope.databinding.MainFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBASICWIDGETCONFIGER = 1;

  private static final int LAYOUT_CARD = 2;

  private static final int LAYOUT_COUNTERIESLISTITEM = 3;

  private static final int LAYOUT_COUNTRIESFRAGMENT = 4;

  private static final int LAYOUT_DETAILSFRAGMENT = 5;

  private static final int LAYOUT_MAINFRAGMENT = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.activity_basic_widget_configer, LAYOUT_ACTIVITYBASICWIDGETCONFIGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.card, LAYOUT_CARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.counteries_list_item, LAYOUT_COUNTERIESLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.countries_fragment, LAYOUT_COUNTRIESFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.details_fragment, LAYOUT_DETAILSFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.abd4ll4h.covid19hope.R.layout.main_fragment, LAYOUT_MAINFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBASICWIDGETCONFIGER: {
          if ("layout/activity_basic_widget_configer_0".equals(tag)) {
            return new ActivityBasicWidgetConfigerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_basic_widget_configer is invalid. Received: " + tag);
        }
        case  LAYOUT_CARD: {
          if ("layout/card_0".equals(tag)) {
            return new CardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for card is invalid. Received: " + tag);
        }
        case  LAYOUT_COUNTERIESLISTITEM: {
          if ("layout/counteries_list_item_0".equals(tag)) {
            return new CounteriesListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for counteries_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_COUNTRIESFRAGMENT: {
          if ("layout/countries_fragment_0".equals(tag)) {
            return new CountriesFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for countries_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DETAILSFRAGMENT: {
          if ("layout/details_fragment_0".equals(tag)) {
            return new DetailsFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for details_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_MAINFRAGMENT: {
          if ("layout/main_fragment_0".equals(tag)) {
            return new MainFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for main_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(10);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "IsEmpty");
      sKeys.put(2, "country");
      sKeys.put(3, "item");
      sKeys.put(4, "global");
      sKeys.put(5, "statu");
      sKeys.put(6, "countries");
      sKeys.put(7, "list");
      sKeys.put(8, "summayData");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_basic_widget_configer_0", com.abd4ll4h.covid19hope.R.layout.activity_basic_widget_configer);
      sKeys.put("layout/card_0", com.abd4ll4h.covid19hope.R.layout.card);
      sKeys.put("layout/counteries_list_item_0", com.abd4ll4h.covid19hope.R.layout.counteries_list_item);
      sKeys.put("layout/countries_fragment_0", com.abd4ll4h.covid19hope.R.layout.countries_fragment);
      sKeys.put("layout/details_fragment_0", com.abd4ll4h.covid19hope.R.layout.details_fragment);
      sKeys.put("layout/main_fragment_0", com.abd4ll4h.covid19hope.R.layout.main_fragment);
    }
  }
}
