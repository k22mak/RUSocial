package ca.ryerson.scs.rus.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ca.ryerson.scs.rus.messenger.objects.Message;
import ca.ryerson.scs.rus.socialite.objects.User;

public class ProcessList {
	public static ArrayList<Message> processMessages(JSONObject response){
		/*
		ArrayList<Category> categories = new ArrayList<Category>();

		try {
			// parse JSONObject and add each category to the list of categories
			JSONArray arr = result.getJSONArray("data");
			for (int i = 0; i < arr.length(); i++) {
				categories.add(new Category(Integer.parseInt(arr.getJSONObject(i).getString("cID")), arr.getJSONObject(i).getString("title"), arr
						.getJSONObject(i).getString("description"), Integer.parseInt(arr.getJSONObject(i).getString("numTopics"))));
			}
		} catch (JSONException e) {
			Log.i(TAG, e.getMessage());
		}

		return categories;
	*/
		ArrayList<Message> messageList = new ArrayList<Message>();
		return messageList;
	}
	
	public static ArrayList<User> processFriends(JSONObject response){
		
		/*ArrayList<JSon> categories = new ArrayList<Category>();

		try {
			// parse JSONObject and add each category to the list of categories
			JSONArray arr = result.getJSONArray("data");
			for (int i = 0; i < arr.length(); i++) {
				categories.add(new Category(Integer.parseInt(arr.getJSONObject(i).getString("cID")), arr.getJSONObject(i).getString("title"), arr
						.getJSONObject(i).getString("description"), Integer.parseInt(arr.getJSONObject(i).getString("numTopics"))));
			}
		} catch (JSONException e) {
			Log.i(TAG, e.getMessage());
		}

		return categories;
	*/
		ArrayList<User> friendList = new ArrayList<User>();
		return friendList;
	}

	public static ArrayList<User> processLocations(JSONArray response){
		
		ArrayList<User> alReturn = new ArrayList<User>();
		//Log.i("PARSING", "THE ARRAY");
		 JSONObject jd;
	      User tempUser;
	      
	     for(int i=0;i<response.length();i++){
	    	 try {
		
			jd = response.getJSONObject(i);
			
		      String username = jd.getString("username");
		      String email =  jd.getString("email");
		      String status = jd.getString("status");
		      String geoX = jd.getString("geoX");
		      String geoY = jd.getString("geoY");
		      
		      System.out.println(i+") " + "Your socialite friend [USER: " + username + "]" + "[EMAIL: " + email + "]" + "[STATUS: " + status + "]" + "[LOCATION: " + geoY +", " +geoX + " ]"); 
		      
		      tempUser = new User(jd.getString("username"),"", jd.getString("status"), "", jd.getString("geoX"), jd.getString("geoY"));
		      alReturn.add(tempUser);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     }
		return alReturn;
	}
}
