package ca.ryerson.scs.rus.util;

import java.util.ArrayList;

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

	public static void processLocations(JSONObject response){
		
	}
}
