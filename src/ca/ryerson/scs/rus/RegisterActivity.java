package ca.ryerson.scs.rus;

import ca.ryerson.scs.rus.util.ValidityCheck;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity implements OnClickListener {
	// Flag for debug/log messages
	public static final boolean DEBUG = true;

	// Tag for debugging
	public static final String TAG = "RyeSocial";

	private TextView btnRegister;

	private EditText evUsername, evPassword, evConfirmPassword,evEmail;

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
			else{
				System.out.println("Testestest");
				
			if ((ValidityCheck.passwordCheck(ValidityCheck.getConfirmedPassword(), ValidityCheck.getPassword()))==true)
					{
						System.out.println("This is true!!!");
					}
			else
					{
						System.out.println("These passwords do not match.");
					}
			}

			// TODO: Create URL using inputs and make an HTTTP Request for
			// authentication
			
		} 

	}
}
