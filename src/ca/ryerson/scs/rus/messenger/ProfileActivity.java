package ca.ryerson.scs.rus.messenger;

import org.json.JSONObject;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.adapters.HttpRequestAdapter;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.URLResource;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity implements OnClickListener {
	
	private TextView tvUsername, tvEmail, tvStatus, btnMessage, btnRequest;
	private Intent intent;
	private Context context;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.profile);
		
		context = this;

		tvUsername = (TextView) findViewById(R.id.TVName);
		tvEmail = (TextView) findViewById(R.id.TVEmail);
		tvStatus = (TextView) findViewById(R.id.TVBio);
		btnMessage = (TextView) findViewById(R.id.BtnMessage);
		btnRequest = (TextView) findViewById(R.id.BtnRequest);
		btnMessage.setFocusable(true);
		btnRequest.setFocusable(true);

		btnMessage.setOnClickListener(this);
		btnRequest.setOnClickListener(this);
		
		intent = getIntent();
		tvUsername.setText(intent.getStringExtra("username"));
		tvEmail.setText(intent.getStringExtra("email"));
		tvStatus.setText(intent.getStringExtra("status"));		
	}

	@Override
	public void onClick(View v) {
		if (v == btnMessage) {
			Intent showProfile = new Intent(IntentRes.NEW_MESSAGE_STRING);
			showProfile.putExtra("receiver", intent.getStringExtra("username"));
			context.startActivity(showProfile); 
		} else if (v == btnRequest) {
			String URLfinal = URLResource.FRIEND_REQUEST+"?user="+DefaultUser.getUser()+"&friend="+intent.getStringExtra("username")+"&state=pending";
			Log.i("THIS IS THE FREIEND REQUEST STRING",""+URLfinal);
			HttpRequestAdapter.httpRequest(context, URLfinal,
					new FriendRequestHandler());
			btnRequest.setClickable(false);
		}

	}
	private class FriendRequestHandler implements HttpRequestAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONObject response) {
			Toast.makeText(context, "Friend Request Sent", Toast.LENGTH_LONG)
			.show();
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub

		}

	}
}
