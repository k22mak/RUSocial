package ca.ryerson.scs.rus.adapters;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.messenger.objects.Friend;
import ca.ryerson.scs.rus.util.DefaultUser;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.URLResource;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FriendsListAdapter extends ArrayAdapter<Friend> {

	private LayoutInflater inflater;
	ArrayList<Friend> users = new ArrayList<Friend>();
	Context context;
	private String usernameString = "";
	private String friendnameString = "";
			
	
	public FriendsListAdapter(Context context, int textViewResourceId,
			ArrayList<Friend> users) {
		super(context, textViewResourceId, users);
		this.users = users;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Friend user = getItem(position);

		if (convertView==null){
			convertView =  inflater.inflate(R.layout.listview_friends, null);
		}
		LinearLayout layout = (LinearLayout)convertView;
		layout.setClickable(true);
		
		TextView username = (TextView) convertView.findViewById(R.id.tvUsername);
		username.setText(user.getUsername());
		
		TextView status = (TextView) convertView.findViewById(R.id.tvStatus);
		status.setText(user.getStatus());
		
		TextView state = (TextView) convertView.findViewById(R.id.tvState);
		state.setText(user.getState());
		
		TextView profileBtn = (TextView) convertView.findViewById(R.id.BtnFLProfile);
		TextView messageBtn = (TextView) convertView.findViewById(R.id.BtnFLMessage);
		
		profileBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent showProfile = new Intent(IntentRes.PROFILE_STRING);
				showProfile.putExtra("username", user.getUsername());
				showProfile.putExtra("email", user.getEmail());
				showProfile.putExtra("status", user.getStatus());
				context.startActivity(showProfile);
			}
		});
		
		messageBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent showProfile = new Intent(IntentRes.NEW_MESSAGE_STRING);
				showProfile.putExtra("receiver", user.getUsername());
				context.startActivity(showProfile); 
			}
		});
		
		layout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if(user.getState().equals("pending")){
					DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
					    @Override
					    public void onClick(DialogInterface dialog, int which) {
					        switch (which){
					        case DialogInterface.BUTTON_POSITIVE:
					        	usernameString = DefaultUser.getUser();
					        	friendnameString = user.getUsername();
										
					        	String URLfinal = URLResource.UPDATE_FRIEND+"?user="+DefaultUser.getUser()+"&friend="+user.getUsername()+"&state=accepted";
					        	HttpRequestArrayAdapter.httpRequest(context, URLfinal,new FriendAcceptHandler());
					        	
					        	
					            break;

					        case DialogInterface.BUTTON_NEGATIVE:
					            //No button clicked
					            break;
					        }
					    }
					};

					AlertDialog.Builder builder = new AlertDialog.Builder(context);
					builder.setMessage("Confirm friend?").setPositiveButton("Accept", dialogClickListener)
					    .setNegativeButton("Decline", dialogClickListener).show();
				}
			}
		});
		
		/*
		ImageView avatar = (ImageView) convertView.findViewById(R.id.FriendAvatar);
		byte[] decodedString = Base64.decode(user.getPicture(), Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length); 
		avatar.setImageBitmap(decodedByte);
		*/
		
		return convertView;
	}

	private class FriendAcceptHandler implements HttpRequestArrayAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONArray response) {
			Toast.makeText(context, "Friend Accepted", Toast.LENGTH_LONG)
			.show();
			String URLfinal = URLResource.FRIEND_REQUEST+"?friend="+DefaultUser.getUser()+"&user="+friendnameString+"&state=accepted";
			Log.i("THIS IS THE FREIEND REQUEST STRING",""+URLfinal);
			HttpRequestAdapter.httpRequest(context, URLfinal,
					new FriendForceAcceptRequestHandler());
			
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub

		}

	}
	
	private class FriendForceAcceptRequestHandler implements HttpRequestAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONObject response) {
			Toast.makeText(context, "Friend Created", Toast.LENGTH_LONG)
			.show();
		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub

		}

	}

}
