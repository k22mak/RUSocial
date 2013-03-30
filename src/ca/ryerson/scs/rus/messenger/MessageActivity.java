package ca.ryerson.scs.rus.messenger;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;
import ca.ryerson.scs.rus.messenger.objects.Message;
import ca.ryerson.scs.rus.util.HttpRequestAdapter;
import ca.ryerson.scs.rus.util.MessageListAdapter;
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
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MessageActivity extends Activity implements OnClickListener {
	private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;
	private final String SOCIALITE_MAP_STRING = "ca.ryerson.scs.rus.socialite.SOCIALITE_MAP";
	private final String MESSAGE_STRING = "ca.ryerson.scs.rus.messenger.MESSAGES_LIST";
	private final String PREFERENCE_STRING = "ca.ryerson.scs.rus.PREFERENCES";
	private final String FRIEND_STRING = "ca.ryerson.scs.rus.messenger.FRIENDS_LIST";
	
	MessageListAdapter mla;
	Context context;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.messages);

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
			json.put("username", "mak");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpRequestAdapter.httpRequest(this, URLResource.LOGIN, json,
				new MessageHandler());
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
			startActivity(new Intent(SOCIALITE_MAP_STRING));

		} else if (v == btnMsg) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Message Button");
			}
			finish();
			startActivity(new Intent(MESSAGE_STRING));

		} else if (v == btnFriend) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Friend Button");
			}
			finish();
			startActivity(new Intent(FRIEND_STRING));

		} else if (v == btnPref) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)
					Log.i(MenuActivity.TAG, "Preference Button");
			}
			finish();
			startActivity(new Intent(PREFERENCE_STRING));
		}
	}
	
	private class MessageHandler implements HttpRequestAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONObject response) {
			ArrayList<Message> messageList = ProcessList.processMessages(response);
			
			mla = new MessageListAdapter(context, 0, messageList);
			
			ListView messageListView = (ListView) findViewById(R.id.list);
			messageListView.setAdapter(mla);

			// add an on click listener for each list item, to show topics for the Category
			messageListView.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> av, View v, int position, long id) {
					// onClick of a category, respective data is sent into the intent
					// topic view for category will be shown
					/* ======== START SINGLE MESSAGE ACTIVITY HERE ========*/
					//Intent showTopics = new Intent(ActionsList.BULLETIN_SHOWTOPICS);
					//showTopics.putExtra("catID", cla.getItem(position).getId());
					//startActivity(showTopics); // start the ShowTopics view
				}
			});
			
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub		
		}
		
	}
}
