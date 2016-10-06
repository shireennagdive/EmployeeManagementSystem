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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForDB implements IemployeeDao {
	static FileInputStream fIn=null;
	static Properties props;
	static String url;
	static Connection connection=null;
	String query;
	SimpleDateFormat formatter = null;
	public static void load() {
		
		try {
			fIn = new FileInputStream("D:/dev/demo/eclipse-workspace/Project/src/com/flp/ems/dao/details.properties");
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
		load();
		query=props.getProperty("jdbc.updatebyKin");
		try(PreparedStatement modify=connection.prepareStatement(query)){
			modify.setString(1,e.getAdress());
			modify.setLong(2,e.getPhone_no());
			modify.setString(3, e.getKin_Id());
			int n = modify.executeUpdate();
		}catch(SQLException E){}
		
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
	
	public Employee search(String KinID,String Name,String EmployeeID){
		Employee emp =null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		load();
		if(KinID.length()!=0){
			query=props.getProperty("jdbc.searchbyEmpKinID");
			}else if(Name.length()!=0){
			query=props.getProperty("");
			}else if(EmployeeID.length()!=0){
			query=props.getProperty("");	
			}
		try(PreparedStatement search = connection.prepareStatement(query)){
			search.setString(1,KinID);
			ResultSet rs=search.executeQuery();
			emp=new Employee();
			while(rs.next()){
				emp.setName(rs.getString(2));
				emp.setKin_Id(rs.getString(3));
				emp.setEmail_id(rs.getString(4));
				emp.setPhone_no(Long.parseLong(rs.getString(5)));
				emp.setDateofbirth((java.util.Date)formatter.parse(rs.getString(6)));
				emp.setDateofjoin((java.util.Date)formatter.parse(rs.getString(7)));
				emp.setAdress(rs.getString(8));
				emp.setDepartmentId(Integer.parseInt(rs.getString(9)));
				emp.setPhone_no(Integer.parseInt(rs.getString(10)));
				emp.setRoleID(Integer.parseInt(rs.getString(11)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ParseException p){
			
		}
		return emp;
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