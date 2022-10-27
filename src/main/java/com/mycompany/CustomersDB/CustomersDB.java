package com.mycompany.CustomersDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomersDB {
	static Connection con;
	static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/manage";
    static String user = "root";
    static String pass = "MinhQuan2807";
	public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,user, pass);
        }
        return con;
    }
}
