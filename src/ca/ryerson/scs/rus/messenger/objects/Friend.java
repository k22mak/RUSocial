package ca.ryerson.scs.rus.messenger.objects;

public class Friend {
	private String username, state, email, status;

	public Friend(String username, String state, String email,
			String status) {
		this.username = username;
		this.status = status;
		this.email = email;
		this.state = state;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String newName) {
		username = newName;
	}

	public String getState() {
		return state;
	}

	public void setState(String newState) {
		state = newState;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String newStatus) {
		status = newStatus;
	}
	

}
