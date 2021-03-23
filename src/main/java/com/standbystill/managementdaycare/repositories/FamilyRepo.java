package com.standbystill.managementdaycare.repositories;

import com.standbystill.managementdaycare.entities.*;

import java.util.List;

public interface FamilyRepo {
    List<Family> fetchAll();

    int addFamily(Family family, int addressId);

    boolean updateFamily(String name, int phone, int familyId);

    boolean deleteFamily(int familyId);

    Family findFamilyById(int familyId);

    List<Family> findFamilyByName(String name);

    List<Parent> findParentsForFamily(int familyId);

    List<Child> findChildrenForFamily(int familyId);

     /*
    QUERIES

    SELECT ALL
    String sql="SELECT * FROM <table name> ORDER BY <param>";

    INSERT NEW RECORD
    String sql="INSERT INTO <table name> (<param1>, <param2>, <param3>...) VALUES (?, ?, ?...)";

    UPDATE RECORD
    String sql="UPDATE <table name> SET <param> = ? WHERE <param> = ?;

    DELETE RECORD
    String sql="DELETE FROM <table name> WHERE <param> = ?;

    FIND BY ...
    String sql="SELECT * FROM <table name> WHERE <param> = ? ORDER BY <param> LIMIT <number> DESC;

    FIND BY ...
    String sql="SELECT * FROM <table name> WHERE <param> IN (SELECT <param1> FROM <table name> WHERE <param2> = ?);

     */

}
