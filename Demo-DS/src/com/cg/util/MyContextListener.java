package com.cg.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

	ServletContext application=arg0.getServletContext();
//		DriverManager.getConnection(url);
		try {
			DataSource ds = ServiceLocator.getDataSource();
			Connection dbConnection = ds.getConnection();
			
			System.out.println("connection obtained!"+(dbConnection != null ));
			
			if(ds != null){
//				ServletContext application = getServletConfig().getServletContext();
				
				application.setAttribute("myDS", ds);
			}
			
			
			
		} catch (SQLException | NamingException e2) {
			e2.printStackTrace();
		}

	}

}
