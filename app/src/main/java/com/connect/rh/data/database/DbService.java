package com.connect.rh.data.database;

import java.util.List;

import com.connect.rh.data.database.tables.StaffTable;
import com.connect.rh.data.database.tables.UserTable;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.entities.entities.UserEntity;
import com.connect.rh.utils.ObjectsMapper;

/**
 * Created by Ali on 2/26/2017.
 * This is a interface which defines the Database service functionality
 */

public class DbService implements IDbService {

    private static DbService dbService;

    private DbService() {

    }

    public static DbService getInstance() {
        if (dbService == null) {
            dbService = new DbService();
        }
        return dbService;
    }

    @Override
    public boolean isUserExist() {
        try {
            long count = UserTable.count(UserTable.class);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public UserEntity getUserInfo(long _id)
    {
        UserTable userTable = null;
        UserEntity entity = new UserEntity();
        try {
            if (_id == 0)
            {
                List<UserTable> userTableList = UserTable.listAll(UserTable.class);
                userTable = userTableList.get(0);
            } else {
                userTable = UserTable.findById(UserTable.class, _id);
            }

/*            entity.id = userTable.getId();
            entity.userName = userTable.userName;
            entity.firstName = userTable.firstName;
            entity.lastName = userTable.lastName;
            entity.dateOfBirth = userTable.dateOfBirth;
            entity.sex = userTable.sex;
            entity.dateOfJoining = userTable.dateOfJoining;
            entity.phone = userTable.phone;
            entity.email = userTable.email;
            entity.timeStamp = userTable.timeStamp;*/
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return entity;
    }


    @Override
    public long createUserInfo(UserEntity entity) {
        try {
//           // UserTable userInfo = new UserTable(entity.userName, entity.firstName, entity.lastName, entity.dateOfBirth, entity.sex, entity.dateOfJoining, entity.phone, entity.email, entity.timeStamp);
//            if (userInfo.save() > 0) {
//                return userInfo.getId();
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return INVALID_REQUEST;
    }

    @Override
    public long updateUserInfo(UserEntity entity) {
        try {
//            UserTable userTable = UserTable.findById(UserTable.class, entity.id);
//            userTable.userName = entity.userName;
//            userTable.firstName = entity.firstName;
//            userTable.lastName = entity.lastName;
//            userTable.dateOfBirth = entity.dateOfBirth;
//            userTable.sex = entity.sex;
//            userTable.dateOfJoining = entity.dateOfJoining;
//            userTable.phone = entity.phone;
//            userTable.email = entity.email;
//            userTable.timeStamp = entity.timeStamp;
//            return userTable.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INVALID_REQUEST;
    }


    @Override
    public boolean deleteUserInfo(long _id) {
        try {
            UserTable userInfo = UserTable.findById(UserTable.class, _id);
            return userInfo.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void createOrUpdate(StaffEntity entity) {
        try
        {
            if(isStaffExist())
            {
                //Update
                updateStaffTable(entity);
            }
            else
            {
                //Create
                createStaffTable(entity);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public long createStaffTable(StaffEntity entity)
    {
        try
        {
            StaffTable staffTable =new StaffTable(
                    entity.staffNumber,
                    entity.firstName_fa,
                    entity.middleName_fa,
                    entity.lastName_fa,
                    entity.firstName_en,
                    entity.middleName_en,
                    entity.lastName_en,
                    entity.seatLocation,
                    entity.phoneNumber,
                    entity.mobileNumber,
                    entity.fax,
                    entity.deapartmentId,
                    entity.deapartmentName_fa,
                    entity.deapartmentName_en,
                    entity.positionId,
                    entity.positionName_fa,
                    entity.positionName_en,
                    entity.userId   );

            if (staffTable.save() > 0)
            {
                return staffTable.getId();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return INVALID_REQUEST;
    }

    public long updateStaffTable(StaffEntity entity)
    {
        try
        {
   /*         StaffTable staffTable=StaffTable.findById(StaffTable.class,entity.seatLocation)

                    entity.staffNumber,
                    entity.firstName_fa,
                    entity.middleName_fa,
                    entity.lastName_fa,
                    entity.firstName_en,
                    entity.middleName_en,
                    entity.lastName_en,
                    entity.seatLocation,
                    entity.phoneNumber,
                    entity.mobileNumber,
                    entity.fax,
                    entity.deapartmentId,
                    entity.deapartmentName,
                    entity.positionId,
                    entity.positionName*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return INVALID_REQUEST;
    }

    public boolean isStaffExist() {
        try {
            long count = StaffTable.count(StaffTable.class);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public void startProcess()
    {
        //TODO::
        //HACK::
    }

    public StaffEntity getStaffEntity(String _userId)
    {
        try {
            List <StaffTable> staffTables = StaffTable.find(StaffTable.class, "staff_number = ?", _userId);
            if(staffTables.size()>0)
            return ObjectsMapper.getStaffEntity(staffTables.get(0));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
