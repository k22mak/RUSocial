package ca.ryerson.scs.rus.socialite;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;

import ca.ryerson.scs.rus.adapters.FriendsListAdapter;
import ca.ryerson.scs.rus.adapters.HttpRequestAdapter;
import ca.ryerson.scs.rus.adapters.HttpRequestArrayAdapter;
import ca.ryerson.scs.rus.adapters.MessageListAdapter;
import ca.ryerson.scs.rus.messenger.objects.Message;
import ca.ryerson.scs.rus.socialite.objects.User;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.ProcessList;
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
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SocialiteListActivity extends Activity implements OnClickListener {
	private Context context;
	private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;
	
	FriendsListAdapter fla;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.socialite_list);

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
		
		
		String URLfinal = ValidityCheck.whiteSpace(URLResource.LOOK_AROUND
				+ "?geoX=1" + "&geoY=2");
		// Log.i("URLFINAL",URLfinal+"a");
		HttpRequestArrayAdapter.httpRequest(this, URLfinal, new UpdateHandler());
		
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
	
	private class UpdateHandler implements HttpRequestArrayAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONArray response) {
			
			try {
				
				Log.i("PARSING", "THE ARRAY"); 
			     for(int i=0;i<response.length();i++){
			      JSONObject jd = response.getJSONObject(i);
			      String username = jd.getString("username");
			      String email =  jd.getString("email");
			      String status = jd.getString("status");
			      String geoX = jd.getString("geoX");
			      String geoY = jd.getString("geoY");
			      System.out.println(i+") " + "Your socialite friend [USER: " + username + "]" + "[EMAIL: " + email + "]" + "[STATUS: " + status + "]" + "[LOCATION: " + geoY +", " +geoX + " ]"); 
				
			   }//FORLOOPEND
			  }
			catch (Exception ex)
			   {
			    Log.e("log_tag", "Error getJSONfromURL "+ex.toString());    
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

