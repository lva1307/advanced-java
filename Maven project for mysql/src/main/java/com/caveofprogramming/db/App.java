package com.caveofprogramming.db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ){
    	 System.out.println( "Hello World!" );
    	 
    	 var db = Database.instance();
    	 
    	 try {                       //que intente conectarse a BD sino capture el error
			db.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo conectar a la Base de datos");
		}
    	 
    	 System.out.println("Conectado");
    	 
    	 try {
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo cerrar la conexion");
		}
    }
}
