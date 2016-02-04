package com.utility;
import java.sql.*;
public class GeneralResources{
	private static Connection connection;
	public static Connection getConnection(){
		if(connection==null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mpeb","root","kumar");
				DatabaseMetaData meta = connection.getMetaData();

                // gets driver info:
				//System.out.println("JDBC driver version is " + meta.getDriverVersion());
			}catch(Exception e){
				System.out.println("Exception in GeneralResources : getConnection() : "+e);
			}
		}
		return connection;
	}
}