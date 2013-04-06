package ca.ryerson.scs.rus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ca.ryerson.scs.rus.R;
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
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Preferences extends Activity implements OnClickListener {
	private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;
	private TextView btnSave, tvName,tvEmail;
	private EditText evStatus;

	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.preferences);

		context = this;

		btnMapView = (ImageButton) findViewById(R.id.IBLook);
		btnHome = (ImageButton) findViewById(R.id.IBHome);
		btnMsg = (ImageButton) findViewById(R.id.IBMsg);
		btnPref = (ImageButton) findViewById(R.id.IBPref);
		btnFriend = (ImageButton) findViewById(R.id.IBFriend);
		btnSave = (TextView) findViewById(R.id.BtnSave);
		evStatus = (EditText) findViewById(R.id.EVBio);
		tvName = (TextView) findViewById(R.id.TVName);
		tvEmail = (TextView) findViewById(R.id.TVEmail);

		btnMapView.setFocusable(true);
		btnHome.setFocusable(true);
		btnMsg.setFocusable(true);
		btnPref.setFocusable(true);
		btnFriend.setFocusable(true);
		btnSave.setFocusable(true);
		evStatus.setFocusable(true);
		tvName.setFocusable(true);

		btnMapView.setOnClickListener(this);
		btnHome.setOnClickListener(this);
		btnMsg.setOnClickListener(this);
		btnPref.setOnClickListener(this);
		btnFriend.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
		tvName.setText(DefaultUser.getUser());
		tvEmail.setText(DefaultUser.getEmail());
	}

	@Override
	public void onClick(View v) {
		if (v == btnHome) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Home button");
			}
			// TODO: Make it go back to the main page while finishing all other
			// activities

		} else if (v == btnMapView) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Map View Button");
			}
			finish();
			startActivity(new Intent(IntentRes.SOCIALITE_MAP_STRING));

		} else if (v == btnMsg) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Message Button");
			}
			finish();
			startActivity(new Intent(IntentRes.MESSAGE_STRING));

		} else if (v == btnFriend) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Friend Button");
			}
			finish();
			startActivity(new Intent(IntentRes.FRIEND_STRING));

		} else if (v == btnPref) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Preference Button");
			}
			finish();
			startActivity(new Intent(IntentRes.PREFERENCE_STRING));
		} else if (v == btnSave) {

			String URLfinal = ValidityCheck.whiteSpace(URLResource.PREFERENCES
					+ "?status_message=" + evStatus.getText().toString()
					+ "&user=" + DefaultUser.getUser());

			HttpRequestArrayAdapter.httpRequest(this, URLfinal, new UpdateHandler());
		}
	}

	private class UpdateHandler implements HttpRequestArrayAdapter.ResponseHandler{
		
		@Override
		public void postResponse(JSONArray response) {
			// TODO Auto-generated method stub
			try {
				
				 JSONObject jd0 = response.getJSONObject(0);
				 String Status = jd0.getString("Status");
				 
				 if (Status.equals("Success")){
					 Toast.makeText(context, "Status update successful",
							 Toast.LENGTH_LONG).show();
				 }
				 
				 else {
					 Toast.makeText(context, "We could not update your status",
							 Toast.LENGTH_LONG).show();
				 }
				finish();
			}

			catch (JSONException e) {
				Toast.makeText(context, "Service Currently Unavailable",
						Toast.LENGTH_LONG).show();
			}
			finish();
		}
		
		@Override
		public void postTimeout() {
			Toast.makeText(context, "Connection timed out", Toast.LENGTH_LONG)
					.show();
		}
	}
}
