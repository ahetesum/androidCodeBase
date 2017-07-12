package com.connect.rh.data.entities.entities;

/**
 * Created by Ali on 4/29/2017.
 */

public class StaffEntity extends Entity
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

    public String getCompleteName(String lang)
    {
        if(lang.equals("fa")) {
            return firstName_fa + " " + middleName_fa + " " + lastName_fa;
        }

        return firstName_en + " " + middleName_en + " " + lastName_en;
    }

    public String getDeapartmentName(String lang)
    {
        if(lang.equals("fa")) {
            return deapartmentName_fa;
        }

        return deapartmentName_en;

    }

    public String getPositionName(String lang) {
        if (lang.equals("fa")) {
            return positionName_fa;
        }

        return positionName_en;
    }

    }
