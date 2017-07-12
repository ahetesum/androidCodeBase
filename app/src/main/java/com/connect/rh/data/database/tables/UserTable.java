package com.connect.rh.data.database.tables;

import com.orm.SugarRecord;

/**
 * Created by Ali on 2/26/2017.
 */

public class UserTable extends SugarRecord {
    public String userName;
    public String firstName;
    public String lastName;
    public String dateOfBirth;
    public String dateOfJoining;
    public String sex;
    public String phone;
    public String email;
    public String timeStamp;

    public UserTable() {
    }

    public UserTable(String userName, String firstName, String lastName, String dateOfBirth, String sex, String dateOfJoining, String phone, String email, String timeStamp) {

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.dateOfJoining = dateOfJoining;
        this.phone = phone;
        this.email = email;
        this.timeStamp = timeStamp;
    }
}
