package ca.ryerson.scs.rus.socialite;

import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class SocialiteListActivity extends Activity implements OnClickListener {

	private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;
	
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
		
	}


