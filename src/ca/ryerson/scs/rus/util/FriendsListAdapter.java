package ca.ryerson.scs.rus.util;

import java.util.ArrayList;
import java.util.List;
import ca.ryerson.scs.rus.socialite.objects.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
		User user = getItem(position);

		// TODO: uncomment when layout is done
		/*
		if (convertView==null){
			convertView =  inflater.inflate(R.layout.bulletin_row_top, null);
		}
		
		TextView username = (TextView) convertView.findViewById(R.id.topTitle);
		username.setText(user.getUsername());
		
		TextView description = (TextView) convertView.findViewById(R.id.topTitle);
		description.setText(user.getDescription());
		
		*/
		return convertView;
	}

}
