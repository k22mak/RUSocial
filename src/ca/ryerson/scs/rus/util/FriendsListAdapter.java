package ca.ryerson.scs.rus.util;

import java.util.ArrayList;
import java.util.List;

import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.socialite.objects.User;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendsListAdapter extends ArrayAdapter<User> {

	private LayoutInflater inflater;
	ArrayList<User> users = new ArrayList<User>();
	Context context;
	
	public FriendsListAdapter(Context context, int textViewResourceId,
			ArrayList<User> user) {
		super(context, textViewResourceId, user);
		this.users = users;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final User user = getItem(position);

		if (convertView==null){
			convertView =  inflater.inflate(R.layout.listview_friends, null);
		}
		
		TextView username = (TextView) convertView.findViewById(R.id.FriendUsername);
		username.setText(user.getUsername());
		
		TextView about = (TextView) convertView.findViewById(R.id.FriendAbout);
		about.setText(user.getAbout());
		
		TextView profileBtn = (TextView) convertView.findViewById(R.id.BtnFLProfile);
		TextView messageBtn = (TextView) convertView.findViewById(R.id.BtnFLMessage);
		
		profileBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent showProfile = new Intent(IntentRes.PROFILE_STRING);
				showProfile.putExtra("username", user.getUsername());
				context.startActivity(showProfile); // start the ShowPosts view
			}
		});
		
		messageBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent showProfile = new Intent("");
				showProfile.putExtra("username", user.getUsername());
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
