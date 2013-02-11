package ca.ryerson.scs.rus.socialite;

import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SocialiteMapActivity extends Activity implements OnClickListener {
	
	private Button btnListView, btnProfile, btnBack;
	private final String SOCIALITE_LIST_STRING="ca.ryerson.scs.rus.socialite.SOCIALITE_LIST";
	private final String PROFILE_STRING = "ca.ryerson.scs.rus.messenger.PROFILE";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.socialize_map);
		
		btnListView = (Button) findViewById(R.id.BtnSocialiteListView);
		btnProfile = (Button) findViewById(R.id.BtnProfile);
		btnBack = (Button) findViewById(R.id.BtnBack);
		
		
		btnListView.setFocusable(true);
		btnProfile.setFocusable(true);
		btnBack.setFocusable(true);
		
		btnListView.setOnClickListener(this);
		btnProfile.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		if (v == btnBack) {
			if (SplashActivity.DEBUG) {
				Log.i(MenuActivity.TAG, "Back Button");
			}
			// TODO: Make it go back to the main page while finishing all other activities			
		} else if (v == btnProfile) {
			if (SplashActivity.DEBUG) {
				Log.i(MenuActivity.TAG, "Profile Button");
			}
			startActivity(new Intent(PROFILE_STRING));
		}else if (v == btnListView) {
			if (SplashActivity.DEBUG) {
				Log.i(MenuActivity.TAG, "List View Button");
			}
			finish();
			startActivity(new Intent(SOCIALITE_LIST_STRING));
		}
	}

}
