package com.connect.rh.data.database.tables;

import com.orm.SugarRecord;

/**
 * Created by Ali on 4/30/2017.
 */

public class StaffTable extends SugarRecord
{
    public String staffNumber;
    public String firstName_fa;
    public String middleName_fa;
    public String lastName_fa;
    public String firstName_en;
    public String middleName_en;
    public String lastName_en;
    public String seatLocation;
    public String phoneNumber;
    public String mobileNumber;
    public String fax;
    public String deapartmentId;
    public String deapartmentName_fa;
    public String deapartmentName_en;
    public String positionId;
    public String positionName_fa;
    public String positionName_en;
    public String userId;

    public StaffTable()
    {
    }

    public StaffTable(String staffNumber, String firstName_fa, String middleName_fa, String lastName_fa, String firstName_en, String middleName_en, String lastName_en, String seatLocation, String phoneNumber, String mobileNumber, String fax, String deapartmentId, String deapartmentName_fa, String deapartmentName_en, String positionId, String positionName_fa, String positionName_en, String userId) {
        this.staffNumber = staffNumber;
        this.firstName_fa = firstName_fa;
        this.middleName_fa = middleName_fa;
        this.lastName_fa = lastName_fa;
        this.firstName_en = firstName_en;
        this.middleName_en = middleName_en;
        this.lastName_en = lastName_en;
        this.seatLocation = seatLocation;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.fax = fax;
        this.deapartmentId = deapartmentId;
        this.deapartmentName_fa = deapartmentName_fa;
        this.deapartmentName_en = deapartmentName_en;
        this.positionId = positionId;
        this.positionName_fa = positionName_fa;
        this.positionName_en = positionName_en;
        this.userId=userId;
    }
}
