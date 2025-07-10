package com.java.atm.transaction;

import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;

import java.time.LocalDate;

public class Withdrawal extends DatabaseConnection {
    public void amount(String AccNo) throws Exception{
        String date = LocalDate.now().toString();
        query("insert into statement_"+AccNo+" (Date,Description,Withdrawal,Balance) values(?,?,?,?)");
        ps.setString(1,date);
        ps.setString(2,"Amount Withdrawal");
        ps.setInt(3, SharedData.getAmount());
        ps.setInt(4, SharedData.getBalance());
        ps.executeUpdate();
        ps.close();
    }
}
