package ca.ryerson.scs.rus;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;

public class SplashActivity extends Activity {
	// Flag for debug/log messages
	public static final boolean DEBUG = true;

	private final String MENU_STRING = "ca.ryerson.scs.rus.MENU";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(100);
					startActivity(new Intent(MENU_STRING));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timer.start();
		
	}
}
