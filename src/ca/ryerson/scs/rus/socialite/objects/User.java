package ca.ryerson.scs.rus.socialite.objects;

public class User {
	private String username,description,picture;
	private double latitude,longitude;
	
	
	public User(String username, String description, String picture, double latitude, double longitude) {
		this.username=username;
		this.description=description;
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
	public String getDescription(){
		return description;
	}
	public void setDescription(String newDescription){
		description=newDescription;
	}
	public double getLongitutde(){
		return longitude;
	}
	public double getLatitude(){
		return latitude;
	}
	public String getPicture(){
		return picture;
	}
	

}
