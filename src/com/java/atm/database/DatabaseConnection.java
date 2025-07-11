package com.java.atm.database;
import java.sql.*;
public class DatabaseConnection {
    public PreparedStatement ps;
    public void query(String q) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/ATM";
        String username = "root";
        String password = "root1234";
        Connection con = DriverManager.getConnection(url,username,password);
        ps = con.prepareStatement(q);
    }
}