// Generated by data binding compiler. Do not edit!
package com.abd4ll4h.covid19hope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.abd4ll4h.covid19hope.R;
import com.abd4ll4h.covid19hope.Status;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class CardBinding extends ViewDataBinding {
  @NonNull
  public final ImageView conform;

  @NonNull
  public final ImageView death;

  @NonNull
  public final ImageView healed;

  @NonNull
  public final ImageView img;

  @NonNull
  public final TextView spinner;

  @Bindable
  protected Status mItem;

  protected CardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView conform, ImageView death, ImageView healed, ImageView img, TextView spinner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.conform = conform;
    this.death = death;
    this.healed = healed;
    this.img = img;
    this.spinner = spinner;
  }

  public abstract void setItem(@Nullable Status item);

  @Nullable
  public Status getItem() {
    return mItem;
  }

  @NonNull
  public static CardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CardBinding>inflateInternal(inflater, R.layout.card, root, attachToRoot, component);
  }

  @NonNull
  public static CardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CardBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<CardBinding>inflateInternal(inflater, R.layout.card, null, false, component);
  }

  public static CardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static CardBinding bind(@NonNull View view, @Nullable Object component) {
    return (CardBinding)bind(component, view, R.layout.card);
  }
}
