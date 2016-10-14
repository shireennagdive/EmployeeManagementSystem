package com.cg;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	DataSource ds=null;
	
	
	public UserDAO(DataSource ds) {
		this.ds = ds;
	}


	public void add(UserDTO udto){
		try {
			Connection dbConnection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
