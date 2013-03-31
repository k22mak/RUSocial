package ca.ryerson.scs.rus.socialite.objects;

public class User {
	private String username,picture, program, about,email;
	private double latitude,longitude;
	
	
	public User(String username, String program, String about, String picture, double latitude, double longitude) {
		this.username=username;
		this.program=program;
		this.about=about;
		this.latitude=latitude;
		this.longitude=longitude;
		this.picture = picture;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String newName){
		username = newName;
	}
	
	public String getProgram(){
		return program;
	}
	
	public void setProgram (String newProgram){
		program = newProgram;
	}
	
	public String getAbout(){
		return about;
	}
	
	public void setAbout(String newAbout){
		about = newAbout;
	}
	
	public void setLongitude(Double newLongitude){
		longitude = newLongitude;
	}
	
	public double getLongitude(){
		return longitude;
	}
	
	public void setLatitude(Double newLatitude){
		latitude = newLatitude;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public void setPicture(String newPicture){
		picture = newPicture;
	}
	
	public String getPicture(){
		return picture;
	}
	
	public void setEmail(String newEmail){
		email= newEmail;
	}
	
	public String getEmail(){
		return email;
	}

}
