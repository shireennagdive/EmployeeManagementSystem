package com.flp.ems.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate {
	private static Matcher matcher;
	private static Pattern pattern;
	private static boolean flag;
	
	public static boolean validateDate(String date)
	{
		java.sql.Date d=java.sql.Date.valueOf(date);
		if(!date.equals(""))
		{
			pattern=Pattern.compile("(((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]))");
			matcher=pattern.matcher(date);
			flag=matcher.matches();
			if(!flag) System.out.println("Invalid Date");
			else{
			int diff=new Date().compareTo(d);
			if(diff<0)
				flag=false;
			if(!flag) System.out.println("Invalid Date");
			else
			{
				  try {
			            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			            df.setLenient(false);
			            df.parse(date);
			            return true;
			        } catch (ParseException e) {
			        	System.out.println("Invalid Date");
			            return false;
			        }
			}
			}
			return flag;
		}
		System.out.println("Invalid Date");
		return false;
	}
	
	public static boolean validatePhone(String ph)
	{
		pattern=Pattern.compile("\\d+");
		matcher=pattern.matcher(ph);
		if(!ph.isEmpty()){
			if((ph.length()==10)&&(matcher.matches()))
				return true;
			else{
				System.out.println("Invalid Phone number: "+ph);
				return false;
			}
		}
		System.out.println("Phone Number cannot be empty");
		return false;
	}
	
	public static boolean validateKinid(String kinid)
	{
		if(!kinid.equals("")){
			return true;
		}
		System.out.println("kinid should not be empty");
		return false;
	}
	
	public static boolean validateemailid(String emailid)
	{
		if(!emailid.equals("")){
			pattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			matcher=pattern.matcher(emailid);
			flag=matcher.matches();
			if(!flag) System.out.println("Invalid Email");
			return flag;
		}
		System.out.println("Invalid Email");
		return false;
	}
	
	public static boolean validatename(String name)
	{
		pattern=Pattern.compile("\\D+");
		if((name.isEmpty())&&!(matcher.matches()))
		{
			System.out.println("Invalid name");
			return false;
		}
		return true;	
	}
}
