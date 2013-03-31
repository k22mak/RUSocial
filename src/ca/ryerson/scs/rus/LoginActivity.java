package ca.ryerson.scs.rus;


import org.json.JSONException;
import org.json.JSONObject;

import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.HttpRequestAdapter;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.URLResource;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements LocationListener,
		OnClickListener {
	// Flag for debug/log messages
	public static final boolean DEBUG = true;

	// Tag for debugging
	public static final String TAG = "RyeSocial";

	private Context context;

	private TextView btnSubmit, btnRegister;
	private EditText evUsername, evPassword;

	private LocationManager locationManager;
	private Location locationSend;

	private static final long MIN_TIME = 400;
	private static final float MIN_DISTANCE = 1000;
	
	private static final String JSON_STATUS = "username";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		context = this;

		btnSubmit = (TextView) findViewById(R.id.BtnSubmit);
		btnRegister = (TextView) findViewById(R.id.BtnRegister);
		evUsername = (EditText) findViewById(R.id.EVUsername);
		evPassword = (EditText) findViewById(R.id.EVPassword);

		btnSubmit.setFocusable(true);
		btnRegister.setFocusable(true);
		evUsername.setFocusable(true);
		evPassword.setFocusable(true);

		btnSubmit.setOnClickListener(this);
		btnRegister.setOnClickListener(this);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

		// TODO: Implement persistence checking for saved username and password
	}

	public void onClick(View v) {
		if (v == btnSubmit) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Login Button");
				Log.i(TAG, evUsername.getText() + " ");
				Log.i(TAG, evPassword.getText() + " ");
			}
			JSONObject json = new JSONObject();
			try {
				json.put("username", evUsername.getText().toString());
				json.put("password", evPassword.getText().toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HttpRequestAdapter.httpRequest(this, URLResource.LOGIN, json,
					new LoginHandler());

			startActivity(new Intent(IntentRes.MENU_STRING));

		} else if (v == btnRegister) {
			startActivity(new Intent(IntentRes.REGISTER_STRING));
		}

	}

	private class LoginHandler implements HttpRequestAdapter.ResponseHandler {
		@Override
		public void postResponse(JSONObject response) {
			try {
				Log.i("RESPONSE", response.getString(JSON_STATUS));
				if (response.getString(JSON_STATUS)==""){
					Intent intent = new Intent(IntentRes.MENU_STRING);
					intent.putExtra("username", evUsername.getText().toString());
					intent.putExtra("location", locationSend);
					DefaultUser.setUser(evUsername.getText().toString());
					startActivity(intent);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Log.i("RESPONSE INFO",""+response.keys());
			/*
			Intent intent = new Intent(MENU_STRING);
			intent.putExtra("username", evUsername.getText().toString());
			intent.putExtra("location", locationSend);
			startActivity(intent);
			*/
		}

		@Override
		public void postTimeout() {
			Toast.makeText(context, "Connection timed out", Toast.LENGTH_LONG)
					.show();
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		locationSend = location;
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
