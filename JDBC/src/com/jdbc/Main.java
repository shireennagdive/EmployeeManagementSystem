package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import java.lang.Class;
public class Main {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {

		// TODO LOAD JDBC PROPERTIES FROM FILE SYSTEM
		FileInputStream fIn = new FileInputStream("dbDetails.properties");
		Properties props = new Properties();
		props.load(fIn);

		// TODO LOAD AND REGISTER JDBC DRIVER
		String driver = props.getProperty("jdbc.driver");
		// Class.forName(driver);

		// TODO GETDATABASE CONNECTION USING JDBC URL
		String url = props.getProperty("jdbc.url");
		Connection dbConnection;
		dbConnection = DriverManager.getConnection(url);
		System.out.println("Connection : " + (dbConnection != null));
        
		/*Statement insertStatement = null;
		try {
			insertStatement = dbConnection.createStatement();
			String query = props.getProperty("jdbc.query.insert");
			int rows = insertStatement.executeUpdate(query);
			System.out.println("rows are : " + rows);
		} finally {
			if (insertStatement != null)
				insertStatement.close();
		}
*/
		/*try (Statement selectStatement = dbConnection.createStatement()) {
			String selectQuery = props.getProperty("jdbc.query2");
			ResultSet result;
			result = selectStatement.executeQuery(selectQuery);
			while (result.next()) {
				String message = result.getString(1);
				System.out.println(message);
			}
		}
		String insertQuery=props.getProperty("jdbc.query.insert");
		try(PreparedStatement prepareStatement = dbConnection.prepareStatement(insertQuery)){
			String value="Neha";
			prepareStatement.setString(1,value);
			
		}*/
		/*String createQuery=props.getProperty("jdbc.query.create");
		try(Statement createStatement = dbConnection.prepareStatement(createQuery)){
			createStatement.executeUpdate(createQuery);
			
		}*/
	//	String insertQuery=props.getProperty("jdbc.query.insert");
		try(Statement insertStatement = dbConnection.createStatement()){
			String name="Neha",value="21";
			String query = props.getProperty("jdbc.query.insert");
			int rows = insertStatement.executeUpdate(query);
			System.out.println("rows are : " + rows);
		}
		
	}
}
