package ca.ryerson.scs.rus.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ca.ryerson.scs.rus.messenger.objects.Friend;
import ca.ryerson.scs.rus.messenger.objects.Message;
import ca.ryerson.scs.rus.socialite.objects.User;

public class ProcessList {
	public static ArrayList<Message> processMessages(JSONObject response) {
		/*
		 * ArrayList<Category> categories = new ArrayList<Category>();
		 * 
		 * try { // parse JSONObject and add each category to the list of
		 * categories JSONArray arr = result.getJSONArray("data"); for (int i =
		 * 0; i < arr.length(); i++) { categories.add(new
		 * Category(Integer.parseInt(arr.getJSONObject(i).getString("cID")),
		 * arr.getJSONObject(i).getString("title"), arr
		 * .getJSONObject(i).getString("description"),
		 * Integer.parseInt(arr.getJSONObject(i).getString("numTopics")))); } }
		 * catch (JSONException e) { Log.i(TAG, e.getMessage()); }
		 * 
		 * return categories;
		 */
		ArrayList<Message> messageList = new ArrayList<Message>();
		return messageList;
	}

	public static ArrayList<Friend> processFriends(JSONArray response) {

		ArrayList<Friend> alReturn = new ArrayList<Friend>();
		JSONObject jd;
		Friend tempUser;

		for (int i = 0; i < response.length(); i++) {
			try {
				jd = response.getJSONObject(i);
				tempUser = new Friend(jd.getString("friend"),
						jd.getString("state"), "a@b.com", "Hello world");
				alReturn.add(tempUser);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return alReturn;
	}

	public static ArrayList<User> processLocations(JSONArray response) {

		ArrayList<User> alReturn = new ArrayList<User>();
		JSONObject jd;
		User tempUser;

		for (int i = 0; i < response.length(); i++) {
			try {
				jd = response.getJSONObject(i);
				tempUser = new User(jd.getString("username"), "",
						jd.getString("status"), "", jd.getString("geoX"),
						jd.getString("geoY"));
				alReturn.add(tempUser);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return alReturn;
	}
}
