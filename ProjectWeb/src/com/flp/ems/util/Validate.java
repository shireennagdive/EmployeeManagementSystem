package com.flp.ems.util;
/*date
 (			#start of group #1
 0?[1-9]		#  01-09 or 1-9
 |                  	#  ..or
 [12][0-9]		#  10-19 or 20-29
 |			#  ..or
 3[01]			#  30, 31
) 			#end of group #1
  /			#  follow by a "/"
   (			#    start of group #2
    0?[1-9]		#	01-09 or 1-9
    |			#	..or
    1[012]		#	10,11,12
    )			#    end of group #2
     /			#	follow by a "/"
      (			#	  start of group #3
       (19|20)\\d\\d	#	    19[0-9][0-9] or 20[0-9][0-9]
       )		#	  end of group #3*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	private static Pattern patternEmail;
	private static Pattern patternDate;
	private static Pattern patternName;
	private static Pattern patternKinID;
	private static Matcher matcher;
	public Validate(){
		
		patternEmail = Pattern.compile(EMAIL_PATTERN);
		patternDate = Pattern.compile(DATE_PATTERN);
		patternName=Pattern.compile(NAME_PATTERN);
		patternKinID=Pattern.compile(KINID_PATTERN);
		
	}
	private static  String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static String DATE_PATTERN =
	          "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
	private static String NAME_PATTERN = "^[a-zA-Z ]*$";
	private static String KINID_PATTERN="^[A-Za-z ][A-Za-z0-9 ]*";
	
	public static boolean validateEmail(String hex) {
		
		return hex.matches(EMAIL_PATTERN);
	}
	public static boolean validateDate(String hex) {

		return hex.matches(DATE_PATTERN);
	}
	public static boolean validateName(String hex) {

		return hex.matches(NAME_PATTERN);
	}	
	public static boolean validateKinID(String hex) {
		
		return hex.matches(KINID_PATTERN);
	}
}