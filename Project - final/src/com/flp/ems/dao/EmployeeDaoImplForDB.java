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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForDB implements IemployeeDao {
	static FileInputStream fIn=null;
	static Properties props;
	static String url;
	static Connection connection=null;
	String query;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Employee emp=null;
	List<Employee> empList=null;
	public static void load() {
		
		try {
			fIn = new FileInputStream("C:/Users/Shireen/workspace/Project/src/com/flp/ems/dao/details.properties");
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
	public void RemoveEmployee(String KinID) { 
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
	
	public Employee SearchEmployee(String KinID,String Name,String EmailID){
		load();
		Employee emp=new Employee();;
		String param="",param1="",param2="",param3="";
		int flag1=0,flag2=0,flag3=0;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		load();
		System.out.println(EmailID);
		if(EmailID.length()==1 && EmailID.equals("-")){
			if(Name.length()==1 && Name.equals("-")){
				query=props.getProperty("jdbc.searchbyEmpKinID"); //onlyKinID
				param=KinID;flag1=1;
			}else{
				if(KinID.length()==1 && KinID.equals("-")){
				query=props.getProperty("jdbc.searchbyEmpName"); //onlyName
				param=Name;flag1=1;
				System.out.println("In Name now in dao");
				}else{
				query=props.getProperty("jdbc.searchbyKinIDName");//NameandKinID	
				param1=KinID;param2=Name;flag2=1;
				}
			}
		}else{ //emailID!=null
			if(KinID.length()==1 && KinID.equals("-")){
				if(Name.length()==1 && KinID.equals("-")){
					query=props.getProperty("jdbc.searchbyEmpEmailID"); //onlyEmailID
					param=EmailID;flag1=1;
				}else{
					query=props.getProperty("jdbc.searchbyNameEmailID");//NameandEmailID
					param1=Name;param2=EmailID;flag2=1;
				}
			}else{//KinID!=null
				if(Name.length()==1 && Name.equals("-")){ 
					query=props.getProperty("jdbc.searchbyKinIDEmailID");//KinIDandEmailID
					param1=KinID;param2=EmailID;flag2=1;
				}else{ //name!=null
					query=props.getProperty("jdbc.searchbyEmpEmailIDNameKinID");  //all three present 
					param1=EmailID;param2=Name;param3=KinID;flag3=1;
				}
			}
		}
		try(PreparedStatement search = connection.prepareStatement(query)){
			if(flag1==1){
				search.setString(1,param);	
				System.out.println("in prepared dao");
			}else if(flag2==1){
				search.setString(1,param1);
				search.setString(2,param2);
			}else if(flag3==1){
				search.setString(1,param1);
				search.setString(2,param2);
				search.setString(3,param3);
			}
			ResultSet rs=search.executeQuery();
			emp=returnEmployeeToService(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		load();
		query=props.getProperty("jdbc.getAll");
		try(Statement st=connection.createStatement()){
			ResultSet rs=st.executeQuery(query);
			empList=returnListToService(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	public Employee returnEmployeeToService(ResultSet rs){
		emp=new Employee();
		try{
		while(rs.next()){
		emp.setEmpID(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setKin_Id(rs.getString(3));
		emp.setEmail_id(rs.getString(4));
		emp.setPhone_no(Long.parseLong(rs.getString(5)));
		emp.setDateofbirth((java.util.Date)formatter.parse(rs.getString(6)));
		emp.setDateofjoin((java.util.Date)formatter.parse(rs.getString(7)));
		emp.setAdress(rs.getString(8));
		emp.setDepartmentId(Integer.parseInt(rs.getString(9)));
		emp.setProjectID((Integer.parseInt(rs.getString(10))));
		emp.setRoleID(Integer.parseInt(rs.getString(11)));
		}
		
		}
		catch(SQLException sql){
			
		}catch(ParseException parse){
			
		}
		return emp;
	}
	
	public List<Employee> returnListToService(ResultSet rs){
		empList=new ArrayList<Employee>();
		try{
		while(rs.next()){
			emp=new Employee();
			emp.setEmpID(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setKin_Id(rs.getString(3));
			emp.setEmail_id(rs.getString(4));
			emp.setPhone_no(Long.parseLong(rs.getString(5)));
			System.out.println("in returntolist.emp is");
			emp.setDateofbirth(((java.util.Date)formatter.parse(rs.getString(6))));
			emp.setDateofjoin((java.util.Date)formatter.parse(rs.getString(7)));
			emp.setAdress(rs.getString(8));
			emp.setDepartmentId(Integer.parseInt(rs.getString(9)));
			emp.setProjectID((Integer.parseInt(rs.getString(10))));
			emp.setRoleID(Integer.parseInt(rs.getString(11)));
			//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			empList.add(emp);
		}
		}catch(SQLException sql){
			
		}catch(ParseException parse){
		System.out.println("exception is : "+parse.toString());	
		}
		return empList;
	}

}