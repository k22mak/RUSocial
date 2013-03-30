package ca.ryerson.scs.rus;

import org.json.JSONException;
import org.json.JSONObject;

import ca.ryerson.scs.rus.util.HttpRequestAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends Activity implements OnClickListener {
	// Tag for debugging
	public static final String TAG = "RyeSocial";

	private final String SOCIALITE_LIST_STRING = "ca.ryerson.scs.rus.socialite.SOCIALITE_LIST";
	private final String MESSAGES_STRING = "ca.ryerson.scs.rus.messenger.MESSAGES_LIST";
	private final String FRIENDS_STRING = "ca.ryerson.scs.rus.messenger.FRIENDS_LIST";
	private final String PREFERENCES_STRING = "ca.ryerson.scs.rus.PREFERENCES";

	private LinearLayout btnLookAround, btnMessages, btnPreferences,
			btnFriendsList;
	
	private TextView tvLookStatus, tvMessageStatus, tvFriendsStatus;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu);

		
		btnLookAround = (LinearLayout) findViewById(R.id.LLLook);
		btnMessages = (LinearLayout) findViewById(R.id.LLMessages);
		btnPreferences = (LinearLayout) findViewById(R.id.LLPrefs);
		btnFriendsList = (LinearLayout) findViewById(R.id.LLFriends);
		
		tvLookStatus = (TextView) findViewById(R.id.TVLookStatus);
		tvFriendsStatus = (TextView) findViewById(R.id.TVFriendsStatus);
		tvMessageStatus = (TextView) findViewById(R.id.TVMessagesStatus);
		
		// TODO: Uncomment when httprequest complete
		/*
		 Intent intent = getIntent();
		 String username = intent.getStringExtra("username");
		
		 JSONObject json = new JSONObject();
				try {
					json.put("username", username);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 HttpRequestAdapter.httpRequest(this, URLResource.REGISTER,json,new StatusHandler());
		 */

		btnLookAround.setFocusable(true);
		btnMessages.setFocusable(true);
		btnPreferences.setFocusable(true);
		btnPreferences.setFocusable(true);
		btnFriendsList.setFocusable(true);

		btnLookAround.setOnClickListener(this);
		btnMessages.setOnClickListener(this);
		btnPreferences.setOnClickListener(this);
		btnPreferences.setOnClickListener(this);
		btnFriendsList.setOnClickListener(this);
	}

	public void onClick(View v) {
		if (v == btnLookAround) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Look Around Button");
			}
			startActivity(new Intent(SOCIALITE_LIST_STRING));
		}  else if (v == btnMessages) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Messenger Button");
			}
			startActivity(new Intent(MESSAGES_STRING));
		} else if (v == btnPreferences) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Preferences Button");
			}
			startActivity(new Intent(PREFERENCES_STRING));
		} else if (v == btnFriendsList) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Friends List Button");
			}
			startActivity(new Intent(FRIENDS_STRING));
		}
	}
	
	private class StatusHandler implements HttpRequestAdapter.ResponseHandler {
		@Override
		public void postResponse(JSONObject response) {
			String messageNumber="", lookAroundNumber="", friendNumber ="";
			
			try {
				lookAroundNumber = response.getString("lookAroundNumber");
				friendNumber = response.getString("friendNumber");
				messageNumber = response.getString("messageNumber");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tvLookStatus.setText(lookAroundNumber+" People Around You");
			tvFriendsStatus.setText(friendNumber+" Friends Online");
			tvMessageStatus.setText(messageNumber +" New Message");
			
		}

		@Override
		public void postTimeout() {
		}
	}

}
