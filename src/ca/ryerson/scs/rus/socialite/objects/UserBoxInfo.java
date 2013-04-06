package ca.ryerson.scs.rus.socialite.objects;

import com.google.android.gms.maps.model.LatLng;

public class UserBoxInfo {

	private LatLng latLong;

	private String username, email, status;

	public UserBoxInfo(LatLng latLong, String username, String email,
			String status) {

		super();
		this.latLong = latLong;
		this.username = username;
		this.email = email;
		this.status = status;

	}
	
	public LatLng getLatLong(){
		return latLong;
	}
	public String getUsername(){
		return username;
	}
	public String getEmail(){
		return email;
	}
	public String getStatus(){
		return status;
	}
	

}
