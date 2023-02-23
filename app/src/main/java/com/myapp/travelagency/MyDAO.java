package com.myapp.travelagency;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface MyDAO {
    @Insert
    void insertAgency(AgencyTable agency);

    @Insert
    void insertTrip(TripTable trip);

    @Insert
    void insertTripPackage(TripPackageTable tripPackage);

    @Delete
    void deleteAgency(AgencyTable agency);

    @Delete
    void deleteTrip(TripTable trip);

    @Delete
    void deleteTripPackage(TripPackageTable tripPackage);

    @Update
    void updateAgency(AgencyTable agency);

    @Update
    void updateTrip(TripTable trip);

    @Update
    void updateTripPackage(TripPackageTable tripPackage);

    @Query("select * from agency_table")
    List<AgencyTable> getAgencyTable();

    @Query("select * from trip_table")
    List<TripTable> getTripTable();

    @Query("select * from package_table")
    List<TripPackageTable> getTripPackageTable();

    @Query("SELECT agency_name as field1, agency_address as field2 " +
            "FROM agency_table")
    List<ResultString> getQuery4();

    @Query("select DISTINCT T.trip_city " +
            "from trip_table T  " +
            "where T.trip_country='Greece'")
    List<String> getQuery5();

    @Query("SELECT T.trip_city as field1 , T.trip_country as field2 " +
            "FROM trip_table T " +
            "WHERE T.trip_days='1'")
    List<ResultString> getQuery6();

    @Query("SELECT T.trip_city as field1 , T.trip_country as field2 " +
            "FROM trip_table T " +
            "WHERE T.trip_type='Ship' AND T.trip_days>'3'")
    List<ResultString> getQuery7();

    @Query("SELECT P.package_id " +
            "FROM package_table P " +
            "WHERE P.package_price>'70'")
    List<Integer> getQuery8();

    @Query("SELECT P.package_id as field1 , T.trip_city as field2 " +
            "FROM package_table P INNER JOIN TRIP_TABLE t ON p.trip_code=t.trip_id " +
            "WHERE t.trip_days>'6' AND (P.package_date='2022/12/24' OR P.package_date='2022/12/25')")
    List<ResultString> getQuery9();

    @Query("SELECT A.agency_name " +
            "FROM AGENCY_TABLE A " +
            "WHERE A.agency_address='Kentro'")
    List<String> getQuery10();

    @Query("SELECT A.agency_name as field1 , P.package_price as field2 " +
            "FROM agency_table A INNER JOIN package_table P ON A.agency_id=P.agency_code INNER JOIN TRIP_TABLE T ON P.trip_code=T.trip_id " +
            "WHERE P.package_date='2022/08/15' and T.trip_city='Nafplio' and t.trip_days='1'")
    List<ResultString> getQuery11();
}
