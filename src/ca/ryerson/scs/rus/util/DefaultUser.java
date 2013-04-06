package ca.ryerson.scs.rus.util;

public class DefaultUser {


	private static String user = "";
	private static String email = "";
	private static String latitude = "";
	private static String longitude = "";
		
	public static void setUser(String username){
		user = username;
	}
	public static String getUser(){
		return user;
	}
	public static void setEmail(String newEmail){
		email = newEmail;
	}
	public static String getEmail(){
		return email;
	}
	public static void setLatitude(String newLatitude){
		latitude = newLatitude;
	}
	public static String getLatitude(){
		return latitude;
	}
	public static void setLongitude(String newLongitude){
		longitude = newLongitude;
	}
	public static String getLongitude(){
		return longitude;
	}
	
			
	

	

}
