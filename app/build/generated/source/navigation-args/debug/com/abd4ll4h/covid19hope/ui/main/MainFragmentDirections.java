package com.abd4ll4h.covid19hope.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.abd4ll4h.covid19hope.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MainFragmentDirections {
  private MainFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMainFragmentToCountries() {
    return new ActionOnlyNavDirections(R.id.action_mainFragment_to_countries);
  }

  @NonNull
  public static ActionMainFragmentToDetails actionMainFragmentToDetails(@NonNull String id) {
    return new ActionMainFragmentToDetails(id);
  }

  public static class ActionMainFragmentToDetails implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToDetails(@NonNull String id) {
      if (id == null) {
        throw new IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id", id);
    }

    @NonNull
    public ActionMainFragmentToDetails setId(@NonNull String id) {
      if (id == null) {
        throw new IllegalArgumentException("Argument \"id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id", id);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("id")) {
        String id = (String) arguments.get("id");
        __result.putString("id", id);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_details;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getId() {
      return (String) arguments.get("id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToDetails that = (ActionMainFragmentToDetails) object;
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getId() != null ? getId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToDetails(actionId=" + getActionId() + "){"
          + "id=" + getId()
          + "}";
    }
  }
}
