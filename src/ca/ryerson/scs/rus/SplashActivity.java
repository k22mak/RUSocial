package ca.ryerson.scs.rus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends Activity {
	// Flag for debug/log messages
	public static final boolean DEBUG = true;

	private final String LOGIN_STRING = "ca.ryerson.scs.rus.LOGIN";

	public static Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);

					ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					NetworkInfo netInfo = connectionManager
							.getActiveNetworkInfo();
					if (netInfo != null && netInfo.isConnectedOrConnecting()) {

						finish();
						startActivity(new Intent(LOGIN_STRING));
					} else {
						finish();
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timer.start();

	}

}
