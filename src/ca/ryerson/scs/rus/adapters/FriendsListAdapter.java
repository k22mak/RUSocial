package ca.ryerson.scs.rus.adapters;

import java.util.ArrayList;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.messenger.objects.Friend;
import ca.ryerson.scs.rus.socialite.objects.User;
import ca.ryerson.scs.rus.util.IntentRes;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FriendsListAdapter extends ArrayAdapter<Friend> {

	private LayoutInflater inflater;
	ArrayList<Friend> users = new ArrayList<Friend>();
	Context context;
	
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
				showProfile.putExtra("usernameRequest", user.getUsername());
				context.startActivity(showProfile); // start the ShowPosts view
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

}
