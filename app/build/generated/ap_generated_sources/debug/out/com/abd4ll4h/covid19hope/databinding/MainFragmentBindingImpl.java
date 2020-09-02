package com.abd4ll4h.covid19hope.databinding;
import com.abd4ll4h.covid19hope.R;
import com.abd4ll4h.covid19hope.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MainFragmentBindingImpl extends MainFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.globle, 7);
        sViewsWithIds.put(R.id.img, 8);
        sViewsWithIds.put(R.id.conform, 9);
        sViewsWithIds.put(R.id.healed, 10);
        sViewsWithIds.put(R.id.death, 11);
        sViewsWithIds.put(R.id.add, 12);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MainFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private MainFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ListView) bindings[5]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            );
        this.list.setTag(null);
        this.main.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setItem((com.abd4ll4h.covid19hope.ui.main.MainViewModel.Variable) variable);
        }
        else if (BR.IsEmpty == variableId) {
            setIsEmpty((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.abd4ll4h.covid19hope.ui.main.MainViewModel.Variable Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setIsEmpty(@Nullable java.lang.Boolean IsEmpty) {
        this.mIsEmpty = IsEmpty;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.IsEmpty);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.abd4ll4h.covid19hope.ui.main.MainViewModel.Variable) object, fieldId);
            case 1 :
                return onChangeItemGlobal((androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Global>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.abd4ll4h.covid19hope.ui.main.MainViewModel.Variable Item, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.global) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeItemGlobal(androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Global> ItemGlobal, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        com.abd4ll4h.covid19hope.ui.main.MainViewModel.Variable item = mItem;
        androidx.databinding.ObservableField<com.abd4ll4h.covid19hope.Global> itemGlobal = null;
        int itemGlobalTotalDeaths = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxIsEmpty = false;
        java.lang.String itemGlobalDate = null;
        int itemGlobalTotalConfirmed = 0;
        java.lang.Boolean isEmpty = mIsEmpty;
        com.abd4ll4h.covid19hope.Global itemGlobalGet = null;
        boolean IsEmpty1 = false;
        int itemGlobalTotalRecovered = 0;

        if ((dirtyFlags & 0xbL) != 0) {



                if (item != null) {
                    // read item.global
                    itemGlobal = item.getGlobal();
                }
                updateRegistration(1, itemGlobal);


                if (itemGlobal != null) {
                    // read item.global.get()
                    itemGlobalGet = itemGlobal.get();
                }


                if (itemGlobalGet != null) {
                    // read item.global.get().totalDeaths
                    itemGlobalTotalDeaths = itemGlobalGet.getTotalDeaths();
                    // read item.global.get().date
                    itemGlobalDate = itemGlobalGet.getDate();
                    // read item.global.get().totalConfirmed
                    itemGlobalTotalConfirmed = itemGlobalGet.getTotalConfirmed();
                    // read item.global.get().totalRecovered
                    itemGlobalTotalRecovered = itemGlobalGet.getTotalRecovered();
                }
        }
        if ((dirtyFlags & 0xcL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(IsEmpty)
                androidxDatabindingViewDataBindingSafeUnboxIsEmpty = androidx.databinding.ViewDataBinding.safeUnbox(isEmpty);


                // read !androidx.databinding.ViewDataBinding.safeUnbox(IsEmpty)
                IsEmpty1 = !androidxDatabindingViewDataBindingSafeUnboxIsEmpty;
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.abd4ll4h.covid19hope.bindingAdapter.IsVisable(this.list, IsEmpty1);
            com.abd4ll4h.covid19hope.bindingAdapter.IsVisable(this.mboundView6, isEmpty);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView1, itemGlobalTotalConfirmed);
            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView2, itemGlobalTotalRecovered);
            com.abd4ll4h.covid19hope.bindingAdapter.convertText(this.mboundView3, itemGlobalTotalDeaths);
            com.abd4ll4h.covid19hope.bindingAdapter.dateFormat(this.mboundView4, itemGlobalDate);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): item.global
        flag 2 (0x3L): IsEmpty
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}