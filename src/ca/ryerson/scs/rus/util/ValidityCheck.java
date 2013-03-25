package ca.ryerson.scs.rus.util;

import java.util.regex.Pattern;

import android.content.SharedPreferences;

public class ValidityCheck {

	private static final String NEW_NAME = "newName";
	private static final String PASSWORD = "password";
	private static final String CONFIRMED_PASSWORD = "confirmedPassword";
	private static final String EMAIL = "email";
	private static final String DEFAULT_RETURN = "";
	private static SharedPreferences preferences;
	private static final Pattern csEmail = Pattern.compile(
	        "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(scs.ryerson.ca)?$"
	);
	private static final Pattern regEmail = Pattern.compile(
	        "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(scs.ryerson.ca)?$"
	);
	private static final Pattern username = Pattern.compile(
	        "^[a-zA-Z0-9]{3,15}$"
	);
	
	public static String getNewUsername() {

		return preferences.getString(NEW_NAME, DEFAULT_RETURN);

	}
	
	//method to get password
	public static String getPassword(){
		
		return ("the");
		//return preferences.getString(PASSWORD,DEFAULT_RETURN);
		
	}
	
	//method to get confirmed password
	public static String getConfirmedPassword(){
		
		return("the");
		//return preferences.getString(CONFIRMED_PASSWORD,DEFAULT_RETURN);
	}
	
	//method to get email
	public static String getEmail(){
		
		return preferences.getString(EMAIL,DEFAULT_RETURN);
	}
	
	//check email ends in "ryerson.ca" or "scs.ryerson.ca"
	
	public static boolean emailCheck (String e){
		if (!csEmail.matcher(e).matches() || !regEmail.matcher(e).matches()) 
			{ return false; }
		return true;
		}
	
	//check username is [a-z]*[A-Z]*[0-9]*
	public static boolean usernameCheck (String u){
		if (!username.matcher(u).matches())
			{ return false; }
		return true;
	}
	
	//check password and confirm-password are the same
	public static boolean passwordCheck (String p, String c){
		if (p.equals(c))
			return true;
		return false;
	}
}
