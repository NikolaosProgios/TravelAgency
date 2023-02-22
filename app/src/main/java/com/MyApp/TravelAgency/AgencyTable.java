
package com.MyApp.TravelAgency;

import androidx.room.ColumnInfo;
import androidx.room.Entity; //gia na oristei i class afti os pinakas
import androidx.room.PrimaryKey;

@Entity(tableName = "agency_table")

public class AgencyTable {
    @PrimaryKey
    @ColumnInfo(name = "agency_id")
    private int id;

    @ColumnInfo(name = "agency_name")
    private String name;

    @ColumnInfo(name = "agency_address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String street) {
        this.address = street;
    }
}
