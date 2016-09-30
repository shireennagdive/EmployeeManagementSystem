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
	private Pattern patternEmail,patternDate,patternName,patternKinID;
	private Matcher matcher;
	public Validate(){
		patternEmail = Pattern.compile(EMAIL_PATTERN);
		patternDate = Pattern.compile(DATE_PATTERN);
	}
	private  String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private String DATE_PATTERN =
	          "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	private String NAME_PATTERN = "^[_A-Za-z\\+]$";
	private String KINID_PATTERN="^[A-Za-z]$";
	
	public boolean validateEmail(String hex) {

		matcher = patternEmail.matcher(hex);
		return matcher.matches();
	}
	public boolean validateDate(String hex) {

		matcher = patternDate.matcher(hex);
		return matcher.matches();
	}
	public boolean validateName(String hex) {

		matcher = patternDate.matcher(hex);
		return matcher.matches();
	}	
	public boolean validateKinID(String hex) {

		matcher = patternDate.matcher(hex);
		return matcher.matches();
	}
}
