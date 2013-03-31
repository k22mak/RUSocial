package ca.ryerson.scs.rus.messenger.objects;

import java.util.Date;


public class Message {
	
	private String username,message, picture;
	private long date;
	private static final int MESSAGE_LENGTH = 20;
	
	
	
	public Message(String username, String message, long date, String picture) {
		this.username=username;
		this.message=message;
		this.date = date;
		this.picture=picture;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String newName){
		username = newName;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String newMessage){
		message = newMessage;
	}
	public String getMessageShort(){
		return message.substring(0,MESSAGE_LENGTH);
	}
	public long getDate(){
		return date;
	}
	public long setDate(){
		Date dateNew = new Date();
		return dateNew.getTime();
	}
	public String getPicture(){
		return picture;
	}

}
