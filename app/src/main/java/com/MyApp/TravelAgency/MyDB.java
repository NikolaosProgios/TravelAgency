
package com.MyApp.TravelAgency;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AgencyTable.class, TripTable.class, TripPackageTable.class}, version = 1)
public abstract class MyDB extends RoomDatabase{
    public abstract MyDAO myDao();
}