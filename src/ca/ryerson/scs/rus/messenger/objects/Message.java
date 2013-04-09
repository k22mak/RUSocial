package ca.ryerson.scs.rus.messenger.objects;

public class Message {
	
	private String username,message, date;
	private static final int MESSAGE_LENGTH = 40;
	private boolean isExpanded;
	
	
	
	public Message(String username, String message, String date) {
		this.username=username;
		this.message=message;
		this.date = date;
		this.isExpanded = false;
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
	public boolean isExpanded(){
		return isExpanded;
	}
	public void changeExpanded(){
		if (isExpanded){
			isExpanded = false;
		}else{
			isExpanded = true;
		}
			
	}


}
