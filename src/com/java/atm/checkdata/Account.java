package com.java.atm.checkdata;

import java.sql.ResultSet;
import java.util.Objects;

import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;

public class Account extends DatabaseConnection {
    private static String value;
    public void setValue(String value){Account.value = value;}
    public String getValue(){return value;}
    public boolean data(String value) throws Exception{
        boolean access = false;
        query("select Name,Account_No from accounts");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if(!Objects.equals(value, SharedData.getAccNo())){
                if(value.equals(rs.getString("Account_No"))){
                    SharedData.setName(rs.getString("Name"));
                    setValue(rs.getString("Account_No"));
                    access = true;
                    ps.close();
                    break;
                }
            }
        }
        return access;
    }
}
