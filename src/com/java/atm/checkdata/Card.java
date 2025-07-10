package com.java.atm.checkdata;

import java.sql.ResultSet;
import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;

public class Card extends DatabaseConnection {
    public boolean data(String cardnumber) throws Exception{
        boolean access = false;
        query("select * from accounts where Card_Number = ?");
        ps.setString(1,cardnumber);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            SharedData.setName(rs.getString("Name"));
            SharedData.setAccNo(rs.getString("Account_No"));
            access = true;
            ps.close();
        }
        return access;
    }
}
