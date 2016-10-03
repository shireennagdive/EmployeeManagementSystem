package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForDB implements IemployeeDao {
	static FileInputStream fIn=null;
	static Properties props;
	static String url;
	static Connection connection=null;
	String query;
	public static void load() {
		
		try {
			fIn = new FileInputStream("C:/Users/Shireen/workspace/Project/bin/com/flp/ems/dao/details.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			props = new Properties();
			try {
				props.load(fIn);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			url=props.getProperty("jdbc.url");
			try {
				connection = DriverManager.getConnection(url);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	@Override
	public void AddEmployee(Employee e) {
		load();
		System.out.println("Connection is : "+(connection!=null));
		query=props.getProperty("jdbc.insertEmp");
		try(PreparedStatement insert = connection.prepareStatement(query)){
			insert.setInt(1,e.getEmp_Id());
			insert.setString(2,e.getName());
			insert.setString(3,e.getKin_Id());
			insert.setString(4,e.getEmail_id());
			insert.setLong(5,e.getPhone_no());
			insert.setDate(6,convertJavaDateToSqlDate(e.getDateofbirth()));
			insert.setDate(7,convertJavaDateToSqlDate(e.getDateofbirth()));
			insert.setString(8,e.getAdress());
			insert.setInt(9,e.getDepartmentId());
			insert.setInt(10,e.getProjectID());
			insert.setInt(11,e.getRoleID());
			insert.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void ModifyEmployee(Employee e) { // dbt see in flp pdf select an employe and modify of employee meaning
		
		
		
	}

	@Override
	public void RemoveEmployee(String KinID) { //dbt how to 
			load();
			query=props.getProperty("jdbc.removeEmpKinID");	
			try(PreparedStatement remove = connection.prepareStatement(query)){
				remove.setString(1,KinID);
				remove.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public void SearchEmployee(String KinID) {
		load();
		query=props.getProperty("jdbc.searchbyEmpKinID");
		try(PreparedStatement search = connection.prepareStatement(query)){
			search.setString(1,KinID);
			ResultSet rs=search.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getAllEmployee() {
		load();
		query=props.getProperty("jdbc.getAll");
		try(Statement st=connection.createStatement()){
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}

}
