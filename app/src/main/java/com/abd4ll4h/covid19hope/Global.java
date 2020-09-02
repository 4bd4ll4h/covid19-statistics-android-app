package com.abd4ll4h.covid19hope;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Global")
public class Global {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private int NewConfirmed;
    @ColumnInfo
    private int TotalConfirmed;
    @ColumnInfo
    private int NewDeaths;
    @ColumnInfo
    private int TotalDeaths;
    @ColumnInfo
    private int NewRecovered;
    @ColumnInfo
    private int TotalRecovered;


    private String date;


    public Global() {
    }

    public Global(String date) {
        this.setDate(date);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        NewDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        NewRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        TotalRecovered = totalRecovered;
    }


}
