// Generated by data binding compiler. Do not edit!
package com.abd4ll4h.covid19hope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.abd4ll4h.covid19hope.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityBasicWidgetConfigerBinding extends ViewDataBinding {
  @NonNull
  public final ListView countiesListWidget;

  @NonNull
  public final TextView textWidget;

  protected ActivityBasicWidgetConfigerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ListView countiesListWidget, TextView textWidget) {
    super(_bindingComponent, _root, _localFieldCount);
    this.countiesListWidget = countiesListWidget;
    this.textWidget = textWidget;
  }

  @NonNull
  public static ActivityBasicWidgetConfigerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_basic_widget_configer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBasicWidgetConfigerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityBasicWidgetConfigerBinding>inflateInternal(inflater, R.layout.activity_basic_widget_configer, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityBasicWidgetConfigerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_basic_widget_configer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityBasicWidgetConfigerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityBasicWidgetConfigerBinding>inflateInternal(inflater, R.layout.activity_basic_widget_configer, null, false, component);
  }

  public static ActivityBasicWidgetConfigerBinding bind(@NonNull View view) {
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
  public static ActivityBasicWidgetConfigerBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityBasicWidgetConfigerBinding)bind(component, view, R.layout.activity_basic_widget_configer);
  }
}