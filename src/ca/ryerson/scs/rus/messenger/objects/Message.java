package ca.ryerson.scs.rus.messenger.objects;

import java.util.Date;


public class Message {
	
	private String username,message, date;
	private static final int MESSAGE_LENGTH = 20;
	
	
	
	public Message(String username, String message, String date) {
		this.username=username;
		this.message=message;
		this.date = date;
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
			return message.substring(0,Math.min(message.length(), MESSAGE_LENGTH));	
	}
	public String getDate(){
		return date;
	}
	public void setDate(String newDate){
		date = newDate;
	}


}
