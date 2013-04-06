package ca.ryerson.scs.rus.util;

import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ValidityCheck {

	private static final Pattern csEmail = Pattern.compile(
	        "^[\\w\\.-]+@ryerson.ca$"
	);
	private static final Pattern regEmail = Pattern.compile(
	        "^[\\w\\.-]+@scs.ryerson.ca$"
	);
	private static final Pattern username = Pattern.compile(
	        "^[a-zA-Z0-9]{3,15}$"
	);
	
	//check email ends in "ryerson.ca" or "scs.ryerson.ca"
	public static boolean emailCheck (String e){
		// || (regEmail.matcher(e).matches() == false)
		if ((csEmail.matcher(e).matches() == false) || regEmail.matcher(e).matches()) 
			{
			return false;
			}
		return true; }
	
	//check user name is [a-z]*[A-Z]*[0-9]*
	public static boolean usernameCheck (String u){
		if (username.matcher(u).matches() == false)
			{ 
			   return false; 
			}
		return true;
	}
	
	//check password and confirm-password are the same
	public static boolean passwordCheck (String p, String c){
		if (p.equals(c))
			return true;
		return false;
	}
	
	public static String whiteSpace (String w){
		w=w.replaceAll("\\s", "%20");
		return w;
		
	}
	public static String removeWhiteSpace (String w){
		w=w.replaceAll("\\s", "");
		return w;
		
	}
	
	public static boolean emptyCheck (String ec){
		if (ec.equals(""))
			return true;
		return false;
	}
	
	public static String statusReturn (JSONArray ja) throws JSONException {
		
		// Grab the first route
		JSONObject route = ja.getJSONObject(0);
		// Take all legs from the route
		String statusJSON = route.getString("Status");
	 
		return statusJSON;
		}
	}
