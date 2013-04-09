package ca.ryerson.scs.rus;

import org.json.JSONArray;
import org.json.JSONObject;

import ca.ryerson.scs.rus.adapters.HttpRequestArrayAdapter;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.URLResource;
import ca.ryerson.scs.rus.util.ValidityCheck;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener {
	// Tag for debugging
	public static final String TAG = "RyeSocial";

	private LinearLayout btnLookAround, btnMessages, btnPreferences,
			btnFriendsList;

	private TextView tvLookStatus, tvMessageStatus, tvFriendsStatus;
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu);
		
		context=this;
		
		btnLookAround = (LinearLayout) findViewById(R.id.LLLook);
		btnMessages = (LinearLayout) findViewById(R.id.LLMessages);
		btnPreferences = (LinearLayout) findViewById(R.id.LLPrefs);
		btnFriendsList = (LinearLayout) findViewById(R.id.LLFriends);

		tvLookStatus = (TextView) findViewById(R.id.TVLookStatus);
		tvFriendsStatus = (TextView) findViewById(R.id.TVFriendsStatus);
		tvMessageStatus = (TextView) findViewById(R.id.TVMessagesStatus);



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

	@Override
	protected void onResume()
	{
	   super.onResume();
	   
		String URLfinal = (ValidityCheck.removeWhiteSpace(URLResource.UPDATE_NUMBERS
				+ "?user=" + DefaultUser.getUser() + "&geoX="
				+ DefaultUser.getLatitude() + "&geoY="
				+ DefaultUser.getLongitude()));
	   HttpRequestArrayAdapter.httpRequest(this, URLfinal, new UpdateNumberHandler());


	   
	}
	
	public void onClick(View v) {
		if (v == btnLookAround) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Look Around Button");
			}
			startActivity(new Intent(IntentRes.SOCIALITE_LIST_STRING));
		} else if (v == btnMessages) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Messenger Button");
			}
			startActivity(new Intent(IntentRes.MESSAGE_STRING));
		} else if (v == btnPreferences) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Preferences Button");
			}
			startActivity(new Intent(IntentRes.PREFERENCE_STRING));
		} else if (v == btnFriendsList) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Friends List Button");
			}
			startActivity(new Intent(IntentRes.FRIEND_STRING));
		}
	}

	private class UpdateNumberHandler implements
			HttpRequestArrayAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONArray response) {

			try {
				if (response.length() == 5) {

					JSONObject tempJSON = response.getJSONObject(0);
					String num_online = tempJSON.getString("num_online_all");

					tempJSON = response.getJSONObject(2);
					String num_messages = tempJSON.getString("num_messages");

					tempJSON = response.getJSONObject(1);
					String num_friends = tempJSON.getString("num_friends");

					Log.i("NUMONLINE",""+num_online);
					Log.i("NUMMSG",""+num_messages);
					Log.i("NUMfd",""+num_friends);
					
					tvLookStatus.setText(num_online + " People Around You");
					tvFriendsStatus.setText(num_friends + " Friends Online");
					tvMessageStatus.setText(num_messages + " Messages");


				}

				else {

					JSONObject jd0 = response.getJSONObject(0);
					String Status = jd0.getString("Status");
					Toast.makeText(
							context,
							"Login " + Status + "\n"
									+ "Incorrect username or password",
							Toast.LENGTH_LONG).show();
				}
			}

			catch (Exception ex) {
				Log.e("log_tag", "Error getJSONfromURL " + ex.toString());
				Toast.makeText(context, "Service Currently Unavailable",
						Toast.LENGTH_LONG).show();
			}

		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub
		}
	}

}
