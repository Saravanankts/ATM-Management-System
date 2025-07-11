package com.java.atm.transaction;

import com.java.atm.checkdata.Account;
import com.java.atm.services.UseExistingServices;
import java.time.LocalDate;
import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;

public class Transfer extends DatabaseConnection {
    Account ac = new Account();
    public void amount()throws Exception {
        String date = LocalDate.now().toString();
        int creditedBalance = 0;
        String AccNo = SharedData.getAccNo();
        int withdrawalBalance = SharedData.getBalance() - SharedData.getAmount();

        query("insert into statement_"+AccNo+" (Date,Description,Withdrawal,Balance) values(?,?,?,?)");
        ps.setString(1,date);
        ps.setString(2,"Transfer Amount to "+ac.getValue()+" Account");
        ps.setInt(3, SharedData.getAmount());
        ps.setInt(4,withdrawalBalance);
        ps.executeUpdate();
        ps.close();

        String dAccNo = ac.getValue();
        new UseExistingServices().service(dAccNo);

        creditedBalance = SharedData.getBalance() + SharedData.getAmount();
        query("insert into statement_"+dAccNo+" (Date,Description,Deposit,Balance) values(?,?,?,?)");
        ps.setString(1,date);
        ps.setString(2,"Received Amount from "+ SharedData.getAccNo()+" Account");
        ps.setInt(3, SharedData.getAmount());
        ps.setInt(4,creditedBalance);
        ps.executeUpdate();
        SharedData.setBalance(withdrawalBalance);
        ps.close();
    }
}
