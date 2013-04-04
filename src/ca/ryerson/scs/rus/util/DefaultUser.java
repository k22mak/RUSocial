package ca.ryerson.scs.rus.util;

public class DefaultUser {


	private static String user = "";
	private static String email = "";
		
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
	
			
	

	

}
