package com.abd4ll4h.covid19hope;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.TypeConverters;

@Entity
public class Status extends Country {
    @ColumnInfo
    private long NewConfirmed;
    @ColumnInfo
    private long TotalConfirmed;
    @ColumnInfo
    private long NewDeaths;
    @ColumnInfo
    private long TotalDeaths;
    @ColumnInfo
    private long NewRecovered;
    @ColumnInfo
    private long TotalRecovered;

    @TypeConverters(Converters.class)
    @ColumnInfo
    private String Date;

    public Status() {
    }

    public Status(long newConfirmed, long totalConfirmed, long newDeaths, long totalDeaths, long newRecovered, long totalRecovered, String date) {
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
        Date = date;
    }

    public long getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(long newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public long getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(long totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public long getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(long newDeaths) {
        NewDeaths = newDeaths;
    }

    public long getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(long totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public long getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(long newRecovered) {
        NewRecovered = newRecovered;
    }

    public long getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(long totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
