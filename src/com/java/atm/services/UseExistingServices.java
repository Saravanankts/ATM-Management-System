package com.java.atm.services;
import com.java.atm.database.DatabaseConnection;
import com.java.atm.ui.SharedData;
import java.sql.*;
import java.time.*;

public class UseExistingServices extends DatabaseConnection {
    public void service(String AccNo)throws Exception{
            String date = LocalDate.now().toString();
            query("show tables like 'statement_"+AccNo+"'");
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                ps.close();
                query("create table statement_" + AccNo + "(" +
                        "Entry_No int auto_increment primary key," +
                        "Date varchar(10)," +
                        "Description varchar(100)," +
                        "Deposit int," +
                        "Withdrawal int," +
                        "Balance int)");
                ps.executeUpdate();
                ps.close();
                query("insert into statement_"+ AccNo +" (Date,Description,Deposit,Balance) values(?,?,?,?)");
                ps.setString(1,date);
                ps.setString(2,"Account Created Successfully");
                ps.setInt(3,1000);
                ps.setInt(4,1000);
                ps.executeUpdate();
                ps.close();
            }
            access(AccNo);
    }
    public void access(String AccNo) throws Exception {
        int Balance = 0;
        //Store Balance data...
        query("select * from statement_"+AccNo);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) Balance = rs.getInt("Balance");
        ps.close();
        SharedData.setBalance(Balance);
    }
}
