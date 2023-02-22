
package com.myapp.travelagency;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trip_table")
public class TripTable {
    @PrimaryKey
    @ColumnInfo(name = "trip_id")
    private int id;

    @ColumnInfo(name = "trip_city")
    private String city;

    @ColumnInfo(name = "trip_country")
    private String country;

    @ColumnInfo(name = "trip_days")
    private int days;

    @ColumnInfo(name = "trip_type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
