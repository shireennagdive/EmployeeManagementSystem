package com.seed;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.cg.String;
import com.seed.beans.ShoppingCart;
import com.seed.DisplayCartDetailsServlet;

//TODO:0	Modification required
public class StoreCartDetailsServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	ShoppingCart cartRef = null;
		
//		TODO:1	Obtain session created for client
//		if session is not created, ask container to create it.
	    
	HttpSession session = request.getSession();//dbt
//		TODO:2	Retrieve attribute named as "shoppingCart" in session scope
//		assign it to "cartRef" local variable (you need casting to ShoppingCart) 
	cartRef=(ShoppingCart) request.getAttribute("shoppingCart");
//		TODO:3 If "shoppingCart" does not exist, create object of com.seed.beans.ShoppingCart referenced by "cartRef"
//		and assign "shoppingCart" as attribute name for this newly created ShoppingCart
	if(cartRef.equals(null)){
		cartRef=new ShoppingCart();
		request.setAttribute("shoppingCart",cartRef);
	}
//		TODO:4	Read product ids from request parameter named as "bookID"
		String array[]=request.getParameterValues("bookID");
	
//		TODO:5 add these product ids in the ShoppingCart object referenced by "cartRef" local variable
	cartRef.setProductList(array);
		
//		TODO:6	if the user clicks "Shop More?" in "bookCatelogue.html", 
//		then redirect web-client to resource named as "categories.html"
	RequestDispatcher dispatcher = request.getRequestDispatcher("categories.html");	//dbt
	
	dispatcher.forward(request, response);

//		TODO:7	if the user clicks "Check Out" in "bookCatelogue.html", 
//		then redirect web-client to resource named as "displayDetails"
//		Add mapping for resource "displayDetails" in WEB.XML
RequestDispatcher dispatcher1 = request.getRequestDispatcher("displayDetails");	
	
	dispatcher1.forward(request, response);
	
	

	}
	
}









