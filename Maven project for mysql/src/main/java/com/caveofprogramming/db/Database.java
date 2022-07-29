package com.caveofprogramming.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static Database db = new Database();        //creo objeto de la clase
	private static final String dbUrl = "jdbc:mysql://localhost:3306/people";
	private Connection conn;
	
	public static Database instance()   {           //metodo para instanciar el objeto
     return db;
	}
	
     private Database() {
     
     }
     
     public void connect() throws SQLException {
    	 conn = DriverManager.getConnection(dbUrl, "root", "1234");
     }
     
     public void close() throws SQLException {
    	 conn.close();
     }
}
