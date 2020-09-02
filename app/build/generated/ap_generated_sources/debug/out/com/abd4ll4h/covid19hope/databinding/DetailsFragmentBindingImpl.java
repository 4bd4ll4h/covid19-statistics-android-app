package com.abd4ll4h.covid19hope.databinding;
import com.abd4ll4h.covid19hope.R;
import com.abd4ll4h.covid19hope.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DetailsFragmentBindingImpl extends DetailsFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.grid, 8);
        sViewsWithIds.put(R.id.imojiTotalRecovered, 9);
        sViewsWithIds.put(R.id.desNewRecovered, 10);
        sViewsWithIds.put(R.id.imojiconformed, 11);
        sViewsWithIds.put(R.id.desRecovered, 12);
        sViewsWithIds.put(R.id.imojiConfirmed, 13);
        sViewsWithIds.put(R.id.desNewConfirmed, 14);
        sViewsWithIds.put(R.id.imojiTotalConfirmed, 15);
        sViewsWithIds.put(R.id.desConfirmed, 16);
        sViewsWithIds.put(R.id.imojiTotalDeaths, 17);
        sViewsWithIds.put(R.id.desNewDeaths, 18);
        sViewsWithIds.put(R.id.imoji, 19);
        sViewsWithIds.put(R.id.desDeaths, 20);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DetailsFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private DetailsFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.GridLayout) bindings[8]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            );
        this.date.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.num.setTag(null);
        this.numConfirmed.setTag(null);
        this.numNewConfirmed.setTag(null);
        this.numTotalConfirmed.setTag(null);
        this.numTotalDeaths.setTag(null);
        this.numconfirmd.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.statu == variableId) {
            setStatu((com.abd4ll4h.covid19hope.DetailsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setStatu(@Nullable com.abd4ll4h.covid19hope.DetailsViewModel Statu) {
        this.mStatu = Statu;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.statu);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeStatuCountr((androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Status>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeStatuCountr(androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Status> StatuCountr, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        long statuCountrNewRecovered = 0;
        long statuCountrNewDeaths = 0;
        java.lang.String statuCountrDate = null;
        long statuCountrTotalDeaths = 0;
        long statuCountrTotalRecovered = 0;
        long statuCountrNewConfirmed = 0;
        long statuCountrTotalConfirmed = 0;
        androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Status> statuCountr = null;
        com.abd4ll4h.covid19hope.Status statuCountrGet = null;
        com.abd4ll4h.covid19hope.DetailsViewModel statu = mStatu;

        if ((dirtyFlags & 0x7L) != 0) {



                if (statu != null) {
                    // read statu.countr
                    statuCountr = statu.getCountr();
                }
                updateRegistration(0, statuCountr);


                if (statuCountr != null) {
                    // read statu.countr.get()
                    statuCountrGet = statuCountr.get();
                }


                if (statuCountrGet != null) {
                    // read statu.countr.get().newRecovered
                    statuCountrNewRecovered = statuCountrGet.getNewRecovered();
                    // read statu.countr.get().newDeaths
                    statuCountrNewDeaths = statuCountrGet.getNewDeaths();
                    // read statu.countr.get().date
                    statuCountrDate = statuCountrGet.getDate();
                    // read statu.countr.get().totalDeaths
                    statuCountrTotalDeaths = statuCountrGet.getTotalDeaths();
                    // read statu.countr.get().totalRecovered
                    statuCountrTotalRecovered = statuCountrGet.getTotalRecovered();
                    // read statu.countr.get().newConfirmed
                    statuCountrNewConfirmed = statuCountrGet.getNewConfirmed();
                    // read statu.countr.get().totalConfirmed
                    statuCountrTotalConfirmed = statuCountrGet.getTotalConfirmed();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.abd4ll4h.covid19hope.bindingAdapter.dateFormat(this.date, statuCountrDate);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.num, statuCountrTotalDeaths);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.numConfirmed, statuCountrNewConfirmed);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.numNewConfirmed, statuCountrNewRecovered);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.numTotalConfirmed, statuCountrTotalConfirmed);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.numTotalDeaths, statuCountrNewDeaths);
            com.abd4ll4h.covid19hope.bindingAdapter.healthNumberConverter(this.numconfirmd, statuCountrTotalRecovered);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): statu.countr
        flag 1 (0x2L): statu
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}