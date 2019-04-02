package id.osg3_20.bikewiseapp.databinding;
import id.osg3_20.bikewiseapp.R;
import id.osg3_20.bikewiseapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemListBindingImpl extends ItemListBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvAddress.setTag(null);
        this.tvTitle.setTag(null);
        this.tvType.setTag(null);
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
        if (BR.incidentDetailVM == variableId) {
            setIncidentDetailVM((id.osg3_20.bikewiseapp.model.IncidentDetail) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIncidentDetailVM(@Nullable id.osg3_20.bikewiseapp.model.IncidentDetail IncidentDetailVM) {
        this.mIncidentDetailVM = IncidentDetailVM;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.incidentDetailVM);
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
        java.lang.String incidentDetailVMTitle = null;
        id.osg3_20.bikewiseapp.model.IncidentDetail incidentDetailVM = mIncidentDetailVM;
        java.lang.String incidentDetailVMType = null;
        java.lang.String incidentDetailVMAddress = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (incidentDetailVM != null) {
                    // read incidentDetailVM.title
                    incidentDetailVMTitle = incidentDetailVM.getTitle();
                    // read incidentDetailVM.type
                    incidentDetailVMType = incidentDetailVM.getType();
                    // read incidentDetailVM.address
                    incidentDetailVMAddress = incidentDetailVM.getAddress();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvAddress, incidentDetailVMAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, incidentDetailVMTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvType, incidentDetailVMType);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): incidentDetailVM
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}