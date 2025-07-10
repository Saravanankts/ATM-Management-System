package com.java.atm.transaction;

import java.time.LocalDate;
import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;

public class Deposit extends DatabaseConnection {
    public void amount(String AccNo) throws Exception {
        String date = LocalDate.now().toString();
        query("insert into statement_"+AccNo+" (Date,Description,Deposit,Balance) values(?,?,?,?)");
        ps.setString(1,date);
        ps.setString(2,"Amount Credited");
        ps.setInt(3, SharedData.getAmount());
        ps.setInt(4, SharedData.getBalance());
        ps.executeUpdate();
        ps.close();
    }
}
