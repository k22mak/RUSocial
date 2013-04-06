package ca.ryerson.scs.rus;

import org.json.JSONException;
import org.json.JSONObject;

import ca.ryerson.scs.rus.adapters.HttpRequestAdapter;
import ca.ryerson.scs.rus.util.URLResource;
import ca.ryerson.scs.rus.util.ValidityCheck;
import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.location.LocationListener;
import android.location.LocationManager;

public class RegisterActivity extends Activity implements OnClickListener, LocationListener {
	// Flag for debug/log messages
	public static final boolean DEBUG = true;

	// Tag for debugging
	public static final String TAG = "RyeSocial";

	private TextView btnRegister;
	private LocationManager locationManager;
	private Location locationSend;

	private EditText evUsername, evPassword, evConfirmPassword, evEmail;

	private static final long MIN_TIME = 400;
	private static final float MIN_DISTANCE = 1000;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);

		btnRegister = (TextView) findViewById(R.id.BtnRegister);
		evUsername = (EditText) findViewById(R.id.EVUsername);
		evPassword = (EditText) findViewById(R.id.EVPassword);
		evConfirmPassword = (EditText) findViewById(R.id.EVConfirmPassword);
		evEmail = (EditText) findViewById(R.id.EVEmail);

		btnRegister.setFocusable(true);
		evUsername.setFocusable(true);
		evPassword.setFocusable(true);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.isProviderEnabled(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
		
		btnRegister.setOnClickListener(this);
		// TODO: Implement persistence checking for saved username and password
	}

	public void onClick(View v) {
		if (v == btnRegister) {
			if (SplashActivity.DEBUG) {
				Log.i(TAG, "Login Button");
				Log.i(TAG, evUsername.getText() + " ");
				Log.i(TAG, evPassword.getText() + " ");
				Log.i(TAG, evConfirmPassword.getText() + " ");
				Log.i(TAG, evEmail.getText() + " ");
			}
			if (ValidityCheck.passwordCheck(evPassword.getText().toString(),
					evConfirmPassword.getText().toString()) == false) // !(ValidityCheck.passwordCheck("else",
																		// "no"))
			{

				final Dialog dialog = new Dialog(RegisterActivity.this);
				dialog.setContentView(R.layout.dialouge_email);
				dialog.setTitle("Password Error");
				dialog.setCancelable(true);

				// set up text
				TextView text = (TextView) dialog.findViewById(R.id.dia_email);
				text.setText(R.string.TVErrPassword);

				// set up button
				Button button = (Button) dialog.findViewById(R.id.Button01);
				button.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
						evPassword.setText("");
						evConfirmPassword.setText("");
					}
				});

				dialog.show();
			} else if (ValidityCheck.emailCheck(evEmail.getText().toString()) == false) {
				final Dialog dialogEmail = new Dialog(RegisterActivity.this);
				dialogEmail.setContentView(R.layout.dialouge_email);
				dialogEmail.setTitle("Email Error");
				dialogEmail.setCancelable(true);

				// set up text
				TextView text = (TextView) dialogEmail
						.findViewById(R.id.dia_email);
				text.setText(R.string.TVErrEmail);

				// set up button
				Button button = (Button) dialogEmail
						.findViewById(R.id.Button01);
				button.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialogEmail.dismiss();
					}
				});

				dialogEmail.show();
			} else if (ValidityCheck.usernameCheck(evUsername.getText()
					.toString()) == false) {
				final Dialog dialogUser = new Dialog(RegisterActivity.this);
				dialogUser.setContentView(R.layout.dialouge_email);
				dialogUser.setTitle("Username Error");
				dialogUser.setCancelable(true);

				// set up text
				TextView text = (TextView) dialogUser
						.findViewById(R.id.dia_email);
				text.setText(R.string.TVErrUsername);

				// set up button
				Button button = (Button) dialogUser.findViewById(R.id.Button01);
				button.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialogUser.dismiss();
					}
				});

				dialogUser.show();
			} else {
				JSONObject json = new JSONObject();
				try {
					json.put("username", evUsername.getText().toString());
					json.put("password", evPassword.getText().toString());
					json.put("email", evEmail.getText().toString());
					json.put("geoX", Double.toString(locationSend.getLatitude()));
					json.put("geoY", Double.toString(locationSend.getLongitude()));
					json.put("status", "Online");
					json.put("status_message", "I am using RUSocial!");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				HttpRequestAdapter.httpRequest(this, URLResource.REGISTER, json,
						new RegisterHandler());
			}
		}
	}

	private class RegisterHandler implements HttpRequestAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONObject response) {
			Toast.makeText(getApplicationContext(), "Successfully Registered",
					Toast.LENGTH_LONG).show();
			finish();
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub

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
