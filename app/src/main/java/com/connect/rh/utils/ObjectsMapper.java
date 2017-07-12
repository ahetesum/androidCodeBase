package com.connect.rh.utils;

import com.connect.rh.data.database.tables.StaffTable;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;

/**
 * Created by Ali on 4/30/2017.
 */

public class ObjectsMapper
{
    public static StaffEntity getStaffEntity(StaffTable table )
    {
        StaffEntity staffEntity=new StaffEntity();

        staffEntity.firstName_en=table.firstName_en;
        staffEntity.middleName_en=table.middleName_en;
        staffEntity.lastName_en=table.lastName_en;

        staffEntity.firstName_fa=table.firstName_fa;
        staffEntity.middleName_fa=table.middleName_fa;
        staffEntity.lastName_fa=table.lastName_fa;

        staffEntity.staffNumber=table.staffNumber;
        staffEntity.seatLocation=table.seatLocation;
        staffEntity.phoneNumber=table.phoneNumber;
        staffEntity.mobileNumber=table.mobileNumber;
        staffEntity.fax=table.fax;

        staffEntity.deapartmentId=table.deapartmentId;
        staffEntity.deapartmentName_en=table.deapartmentName_en;
        staffEntity.deapartmentName_fa=table.deapartmentName_fa;

        staffEntity.positionId=table.positionId;
        staffEntity.positionName_fa=table.positionName_fa;
        staffEntity.positionName_en=table.positionName_en;

        staffEntity.userId=table.userId;

        return staffEntity;
    }
}
