package application;

import java.lang.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		int[] ids = {0,1,2};   
		String[] names = {"Bere", "Teo", "Lore"}; 
		
		Class.forName("org.sqlite.JDBC");
		
		String dbUrl = "jdbc:sqlite:people.db";
		
		var conn = DriverManager.getConnection(dbUrl);
		var stmt = conn.createStatement();      
		conn.setAutoCommit(false);
       
        
        var sql = "insert into user (id, name) values (?, ?)";
        var insertStmt = conn.prepareStatement(sql);
        
        for(int i=0; i<ids.length; i++) {
        	insertStmt.setInt(1,ids[i]);
        	insertStmt.setString(2,names[i]);
        	
        	insertStmt.executeUpdate();
        	
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
