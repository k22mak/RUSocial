package ca.ryerson.scs.rus.adapters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.messenger.objects.Message;
import ca.ryerson.scs.rus.util.IntentRes;
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
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageListAdapter extends ArrayAdapter<Message> {

	private LayoutInflater inflater;
	ArrayList<Message> messages = new ArrayList<Message>();
	Context context;

	public MessageListAdapter(Context context, int textViewResourceId,
			ArrayList<Message> messages) {
		super(context, textViewResourceId, messages);
		this.messages = messages;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Message message = getItem(position); // auto loops and knows how
													// many msgs in arraylist
		View v = convertView;
		
		// TODO: uncomment when layout is done

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listview_msgs, null);
		}

		LinearLayout clickExpander = (LinearLayout)convertView.findViewById(R.id.clickExpander);
		
		
		TextView username = (TextView) convertView.findViewById(R.id.MsgTVUser);
		username.setText(message.getUsername());

		final TextView msg = (TextView) convertView.findViewById(R.id.MsgTVMsg);
		msg.setText(message.getMessageShort());

		TextView msgDate = (TextView) convertView.findViewById(R.id.MsgTVDate);
		msgDate.setText(message.getDate());

		clickExpander.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (message.isExpanded()) {
					msg.setText(message.getMessage());
					message.changeExpanded();
				} else {
					msg.setText(message.getMessageShort());
					message.changeExpanded();
				}
			}
		});

		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 * String stringDate = formatter.format(message.getDate());
		 * msgDate.setText(stringDate);
		 */
		/*
		 * ImageView avatar = (ImageView)
		 * convertView.findViewById(R.id.MsgIVAvatar); byte[] decodedString =
		 * Base64.decode(message.getPicture(), Base64.DEFAULT); Bitmap
		 * decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,
		 * decodedString.length); avatar.setImageBitmap(decodedByte);
		 */

		return convertView;
	}
}
