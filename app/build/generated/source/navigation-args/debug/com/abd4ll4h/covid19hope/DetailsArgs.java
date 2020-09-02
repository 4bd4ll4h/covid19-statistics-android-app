package com.abd4ll4h.covid19hope;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DetailsArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private DetailsArgs() {
  }

  private DetailsArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static DetailsArgs fromBundle(@NonNull Bundle bundle) {
    DetailsArgs __result = new DetailsArgs();
    bundle.setClassLoader(DetailsArgs.class.getClassLoader());
    if (bundle.containsKey("id")) {
      String id;
      id = bundle.getString("id");
      if (id == null) {
        throw new IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getId() {
    return (String) arguments.get("id");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("id")) {
      String id = (String) arguments.get("id");
      __result.putString("id", id);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    DetailsArgs that = (DetailsArgs) object;
    if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
      return false;
    }
    if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getId() != null ? getId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DetailsArgs{"
        + "id=" + getId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(DetailsArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String id) {
      if (id == null) {
        throw new IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id", id);
    }

    @NonNull
    public DetailsArgs build() {
      DetailsArgs result = new DetailsArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setId(@NonNull String id) {
      if (id == null) {
        throw new IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id", id);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getId() {
      return (String) arguments.get("id");
    }
  }
}
