package ca.ryerson.scs.rus.messenger;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;
import ca.ryerson.scs.rus.adapters.FriendsListAdapter;
import ca.ryerson.scs.rus.adapters.HttpRequestAdapter;
import ca.ryerson.scs.rus.socialite.objects.User;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.ProcessList;
import ca.ryerson.scs.rus.util.URLResource;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class FriendsListActivity extends Activity implements OnClickListener {
	private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;

	private Context context;

	FriendsListAdapter fla;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.friends_list);

		context = this;
		btnMapView = (ImageButton) findViewById(R.id.IBLook);
		btnHome = (ImageButton) findViewById(R.id.IBHome);
		btnMsg = (ImageButton) findViewById(R.id.IBMsg);
		btnPref = (ImageButton) findViewById(R.id.IBPref);
		btnFriend = (ImageButton) findViewById(R.id.IBFriend);

		btnMapView.setFocusable(true);
		btnHome.setFocusable(true);
		btnMsg.setFocusable(true);
		btnPref.setFocusable(true);
		btnFriend.setFocusable(true);

		btnMapView.setOnClickListener(this);
		btnHome.setOnClickListener(this);
		btnMsg.setOnClickListener(this);
		btnPref.setOnClickListener(this);
		btnFriend.setOnClickListener(this);

		JSONObject json = new JSONObject();
		try {
			Intent intent = getIntent();
			json.put("username", intent.getStringExtra("username"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpRequestAdapter.httpRequest(this, URLResource.MESSAGES, json,
				new FriendsHandler());
	}

	@Override
	public void onClick(View v) {
		if (v == btnHome) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Home button");
			}
			// TODO: Make it go back to the main page while finishing all other activities
			
		}else if (v == btnMapView) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Map View Button");
			}
			Intent newIntent = new Intent(IntentRes.SOCIALITE_MAP_STRING);
			newIntent.putExtra("username", DefaultUser.getUser());
			finish();
			startActivity(newIntent);
		
		}else if (v == btnMsg) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Message Button");
			}
			Intent newIntent = new Intent(IntentRes.MESSAGE_STRING);
			newIntent.putExtra("username", DefaultUser.getUser());
			finish();
			startActivity(newIntent);
		
		}else if (v == btnFriend) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Friend Button");
			}
			Intent newIntent = new Intent(IntentRes.FRIEND_STRING);
			newIntent.putExtra("username", DefaultUser.getUser());
			finish();
			startActivity(newIntent);
			
			
		}else if (v == btnPref) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Preference Button");
				}
			Intent newIntent = new Intent(IntentRes.PREFERENCE_STRING);
			newIntent.putExtra("username", DefaultUser.getUser());
			finish();
			startActivity(newIntent);
			}
	}

	private class FriendsHandler implements HttpRequestAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONObject response) {
			final ArrayList<User> friendsList = ProcessList
					.processFriends(response);
			fla = new FriendsListAdapter(context, 0, friendsList);
			ListView messageListView = (ListView) findViewById(R.id.list);
			messageListView.setAdapter(fla);
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub
		}

	}

}
