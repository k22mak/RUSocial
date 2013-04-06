package ca.ryerson.scs.rus.socialite.objects;

public class User {
	private String username,picture, program, about,email,latitude,longitude;
	
	
	
	public User(String username, String email, String about, String picture, String latitude, String longitude) {
		this.username=username;
		this.email=email;
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
	
	public void setLongitude(String newLongitude){
		longitude = newLongitude;
	}
	
	public String getLongitude(){
		return longitude;
	}
	
	public void setLatitude(String newLatitude){
		latitude = newLatitude;
	}
	
	public String getLatitude(){
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
