package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_KEY = "action";
    private static final String GETALL_ACTION = "getAll";
    private static final String ADD_ACTION = "add";
    private static final String SEARCH_ACTION = "search";
    private static final String MODIFY_ACTION = "modify";
    private static final String REMOVE_ACTION = "remove";
    private static final String ERROR_KEY = "errorMessage";
    String destinationPage = null; 
    HashMap<String,String> hm=null;
    EmployeeServiceImpl service=null;
    PrintWriter out=null;
    List<HashMap<String, String>> mapList=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_KEY);
        
        // perform action
        if(GETALL_ACTION.equals(actionName))
        {     
        	
        	service = new EmployeeServiceImpl();
        	out=response.getWriter();
        	mapList = service.getAllEmployee();
    		for(int i=0;i<mapList.size();i++){
    			hm=mapList.get(i);
    			for (String key: hm.keySet()){
    	            String value = hm.get(key);  
    	            out.println(key + " : " + value);  
    	            out.println();
    	}
    			out.println();
    		}
    	
            //TODO 4 
			//Use carDao to get the list of the cars
			//Set the list in request with attribute name as 'carList'
			//Set the destination page to carList.jsp
			
	}
        else if(ADD_ACTION.equals(actionName))
        {
        	System.out.println("actionName is : "+actionName);
        	service = new EmployeeServiceImpl();
        	hm=new HashMap<String,String>();
			hm.put("Name",request.getParameter("Name"));
			hm.put("PhoneNumber",request.getParameter("PhoneNumber"));
			hm.put("Adress",request.getParameter("Adress"));
			hm.put("DateOfBirth",request.getParameter("DateOfBirth"));
			hm.put("DateOfJoining",request.getParameter("DateOfJoining"));
			hm.put("DepartmentID",request.getParameter("DepartmentID"));
			hm.put("ProjectID",request.getParameter("ProjectID"));
			hm.put("RoleID",request.getParameter("RoleID"));
			service.AddEmployee(hm);
			
			//TODO 5 
			//Create a new CarDTO and set in request with attribute name as 'car'
			//Set the destination page to carForm.jsp
            
        }  
        else if(MODIFY_ACTION.equals(actionName))
        {
        	System.out.println("actionName is : "+actionName);
        	service = new EmployeeServiceImpl();
        	hm = new HashMap<String,String>();
    		
    			hm.put("KinID",request.getParameter("KinID"));
    			hm.put("Name",request.getParameter("Name"));
    			hm.put("EmailID",request.getParameter("EmailID"));
    		    hm.put("Adress",request.getParameter("Adress"));
    		    hm.put("PhoneNumber",request.getParameter("PhoneNumber"));
    		    hm.put("ProjectID",request.getParameter("ProjectID"));
    		    service.ModifyEmployee(hm);
        	//TODO 6 
			//Get the car id from request, with parameter name as 'id'
			//Find the respective car (CarDTO) from carDAO using appropriate API of DAO
			//Set the found car in request with name as 'car'
			//Set the destination page to carForm.jsp
            
        }        
        else if(SEARCH_ACTION.equals(actionName))
        {	out=response.getWriter();
        	service = new EmployeeServiceImpl();hm=service.SearchEmployee(request.getParameter("KinID"),request.getParameter("Name"),request.getParameter("EmailID"));
    		for (String key: hm.keySet()){
                String value = hm.get(key);  
                out.println(key + " " + value);  
			//TODO 7 
			//Create a new CarDTO
			//set the properties of the DTO from request parameters
			//If it is a new car then invoke create api of DAO else update api
			//Get all the Cars using DAO
			//Set the found cars in request with name as 'carList'
			//Set the destination page to carList.jsp
			
    		}
        }  
        else if(REMOVE_ACTION.equals(actionName))
        {
        	service = new EmployeeServiceImpl();
        	service.RemoveEmployee(request.getParameter("KinID"));
            //TODO 8 
			//Get the ids of all cars to be deleted from request
			//Use appropriate api of DAO to delete all cars 
			//Get all the Cars using DAO
			//Set the found cars in request with name as 'carList'
			//Set the destination page to carList.jsp
            
        }                    
        else
        {
            String errorMessage = "[" + actionName + "] is not a valid action.";
            request.setAttribute(ERROR_KEY, errorMessage);
        }


        //TODO 9 Use appropriate Servlet API to forward the request to 
		//appropriate destination page set in above if else blocks depending on action.
        
    }

}