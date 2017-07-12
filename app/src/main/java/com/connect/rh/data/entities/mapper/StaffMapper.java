package com.connect.rh.data.entities.mapper;

import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.entities.entities.UserEntity;

import org.json.JSONObject;

/**
 * Created by Ali on 4/29/2017.
 */

public class StaffMapper extends EntityMapper
{
    private StaffEntity staffEntity = null;

    public StaffMapper()
    {
        staffEntity = new StaffEntity();
    }

    @Override
    public Entity transform(String jsonResponse)
    {
        try {
            JSONObject loginObject = new JSONObject(jsonResponse);
            trasformCommonValues(staffEntity, loginObject);


            staffEntity.staffNumber = loginObject.optString("staffNumber");
            staffEntity.firstName_en = loginObject.optString("firstName_en");
            staffEntity.middleName_en = loginObject.optString("middleName_en");
            staffEntity.lastName_en = loginObject.optString("lastName_en");

            staffEntity.firstName_fa = loginObject.optString("firstName_fa");
            staffEntity.middleName_fa = loginObject.optString("middleName_fa");
            staffEntity.lastName_fa = loginObject.optString("lastName_fa");

            staffEntity.seatLocation = loginObject.optString("seatLocation");
            staffEntity.phoneNumber = loginObject.optString("phoneNumber");
            staffEntity.mobileNumber = loginObject.optString("mobileNumber");
            staffEntity.fax = loginObject.optString("fax");

            JSONObject deptJsonObject=loginObject.getJSONObject("department");
            staffEntity.deapartmentId = deptJsonObject.optString("id");
            staffEntity.deapartmentName_fa = deptJsonObject.optString("name_fa");
            staffEntity.deapartmentName_en = deptJsonObject.optString("name_en");

            JSONObject posJsonObject=loginObject.getJSONObject("department");
            staffEntity.positionId = posJsonObject.optString("id");
            staffEntity.positionName_fa = posJsonObject.optString("name_fa");
            staffEntity.positionName_en = posJsonObject.optString("name_en");

            //TODO:: icon parshing
            //JSONObject imageJsonObject=loginObject.getJSONObject("icon");
            //staffEntity.positionId = imageJsonObject.optString("iconUrl");

            JSONObject userJsonObject=loginObject.getJSONObject("user");
            staffEntity.userId = userJsonObject.optString("id");
            return staffEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
