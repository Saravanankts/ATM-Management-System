package com.java.atm.checkdata;

import com.java.atm.database.DatabaseConnection;
import java.sql.ResultSet;

public class PinValidator extends DatabaseConnection {
    public boolean data(int pin, String cardnumber) throws Exception{
        query("select * from accounts where Card_Number = ?");
        ps.setString(1,cardnumber);
        ResultSet rs = ps.executeQuery();
        rs.next();
        boolean access = (pin == rs.getInt("Pin"));
        ps.close();
        return access;
    }
}
