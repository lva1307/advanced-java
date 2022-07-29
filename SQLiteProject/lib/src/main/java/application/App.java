package application;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.lang.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		int[] ids = {0,1,2};   
		String[] names = {"Bere", "Teo", "Lore"}; 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbUrl = "jdbc:mysql://localhost:3306/people";
		
		var conn = DriverManager.getConnection(dbUrl, "root", "1234");
		var stmt = conn.createStatement();      
		conn.setAutoCommit(false);
         
        var sql = "insert into user (id, name) values (?,?)";
        var insertStmt = conn.prepareStatement(sql);
        
        for(int i=0; i<ids.length; i++) {
        	insertStmt.setInt(1,ids[i]);
        	insertStmt.setString(2,names[i]);
        	
        }
        
        conn.commit();
        
       insertStmt.close();
        
        sql = "select id, name from user";
        var rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	System.out.println(id + ":" + name);
        	
        }
        
        
        stmt.close();
		
		conn.close();
	}

}
