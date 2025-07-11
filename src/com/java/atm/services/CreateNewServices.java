package com.java.atm.services;

import java.sql.*;
import com.java.atm.database.DatabaseConnection;

public class CreateNewServices extends DatabaseConnection {
    public void service(String cardnumber,String AccNo,String Name,int pin) throws Exception{
        if(Long.parseLong(cardnumber) - Long.parseLong(cardnumber) == 0 && Long.parseLong(AccNo) - Long.parseLong(AccNo) == 0) {
            query("show tables like 'accounts'");
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                ps.close();
                query("create table accounts(" +
                        "No_of_Accounts int auto_increment unique," +
                        "Card_Number varchar(16) primary key," +
                        "Account_No varchar(18) unique not null," +
                        "Name varchar(50) not null," +
                        "pin int(4) not null)");
                ps.executeUpdate();
                ps.close();
            }
            query("insert into accounts(Card_Number,Account_No,Name,pin) values(?,?,?,?)");
            ps.setString(1, cardnumber);
            ps.setString(2, AccNo);
            ps.setString(3, Name);
            ps.setInt(4, pin);
            ps.executeUpdate();
            ps.close();
        }
        else throw new SQLException();
    }
}
