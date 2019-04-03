package id.osg3_20.bikewiseapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.osg3_20.bikewiseapp.model.IncidentDetail;

public abstract class ItemListBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvType;

  @Bindable
  protected IncidentDetail mIncidentDetailVM;

  protected ItemListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView tvAddress, TextView tvTitle, TextView tvType) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvAddress = tvAddress;
    this.tvTitle = tvTitle;
    this.tvType = tvType;
  }

  public abstract void setIncidentDetailVM(@Nullable IncidentDetail incidentDetailVM);

  @Nullable
  public IncidentDetail getIncidentDetailVM() {
    return mIncidentDetailVM;
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemListBinding>inflate(inflater, id.osg3_20.bikewiseapp.R.layout.item_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemListBinding>inflate(inflater, id.osg3_20.bikewiseapp.R.layout.item_list, null, false, component);
  }

  public static ItemListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemListBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ItemListBinding)bind(component, view, id.osg3_20.bikewiseapp.R.layout.item_list);
  }
}
