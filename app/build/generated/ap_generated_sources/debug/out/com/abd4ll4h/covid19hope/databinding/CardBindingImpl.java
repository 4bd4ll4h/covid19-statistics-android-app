package com.abd4ll4h.covid19hope.databinding;
import com.abd4ll4h.covid19hope.R;
import com.abd4ll4h.covid19hope.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CardBindingImpl extends CardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.spinner, 7);
        sViewsWithIds.put(R.id.conform, 8);
        sViewsWithIds.put(R.id.healed, 9);
        sViewsWithIds.put(R.id.death, 10);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private CardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[7]
            );
        this.img.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((com.abd4ll4h.covid19hope.Status) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.abd4ll4h.covid19hope.Status Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        long itemTotalConfirmed = 0;
        com.abd4ll4h.covid19hope.Status item = mItem;
        long itemTotalDeaths = 0;
        java.lang.String itemCountry = null;
        java.lang.String itemId = null;
        long itemTotalRecovered = 0;
        java.lang.String itemDate = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.TotalConfirmed
                    itemTotalConfirmed = item.getTotalConfirmed();
                    // read item.TotalDeaths
                    itemTotalDeaths = item.getTotalDeaths();
                    // read item.country
                    itemCountry = item.getCountry();
                    // read item.id
                    itemId = item.getId();
                    // read item.TotalRecovered
                    itemTotalRecovered = item.getTotalRecovered();
                    // read item.Date
                    itemDate = item.getDate();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.abd4ll4h.covid19hope.bindingAdapter.loadFlag(this.img, itemId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, itemCountry);
            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView3, itemTotalConfirmed);
            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView4, itemTotalRecovered);
            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView5, itemTotalDeaths);
            com.abd4ll4h.covid19hope.bindingAdapter.dateFormat(this.mboundView6, itemDate);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}