package ca.ryerson.scs.rus.socialite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.Menu;

import ca.ryerson.scs.rus.MenuActivity;
import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.SplashActivity;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;



import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SocialiteMapActivity extends Activity implements LocationListener, OnClickListener {
  static final LatLng HAMBURG = new LatLng(53.558, 9.927);
  static final LatLng KIEL = new LatLng(53.551, 9.993);
  private GoogleMap map;
  LocationManager locationManager;
  private static final long MIN_TIME = 400;
  private static final float MIN_DISTANCE = 1000;
  private ImageButton btnMapView, btnHome, btnMsg, btnPref, btnFriend;
  private final String SOCIALITE_MAP_STRING="ca.ryerson.scs.rus.socialite.SOCIALITE_MAP";
  private final String MESSAGE_STRING="ca.ryerson.scs.rus.messenger.MESSAGES_LIST";
  private final String PREFERENCE_STRING="ca.ryerson.scs.rus.PREFERENCES";
  private final String FRIEND_STRING="ca.ryerson.scs.rus.messenger.FRIENDS_LIST";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.socialize_map);
	    GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
	      
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
	    
	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
	        .getMap();
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);         


	    /*
	    Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
	        .title("Hamburg"));
	    Marker kiel = map.addMarker(new MarkerOptions()
	        .position(KIEL)
	        .title("Kiel")
	        .snippet("Kiel is cool")
	        .icon(BitmapDescriptorFactory
	            .fromResource(R.drawable.ic_launcher)));
*/
	    // Move the camera instantly to hamburg with a zoom of 15.
	    //map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

	    // Zoom in, animating the camera.
	    //map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	  }
  
  @Override
  public void onClick(View v) {
		if (v == btnHome) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Home button");
			}
			// TODO: Make it go back to the main page while finishing all other activities
			
		}else if (v == btnMapView) {
			if (SplashActivity.DEBUG) {
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Map View Button");
			}
			finish();
			startActivity(new Intent(SOCIALITE_MAP_STRING));
		
		}else if (v == btnMsg) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Message Button");
			}
			finish();
			startActivity(new Intent(MESSAGE_STRING));
		
		}else if (v == btnFriend) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Friend Button");
			}
			finish();
			startActivity(new Intent(FRIEND_STRING));
			
		}else if (v == btnPref) {
			if (SplashActivity.DEBUG){
				if (SplashActivity.DEBUG)Log.i(MenuActivity.TAG, "Preference Button");
				}
			finish();
			startActivity(new Intent(PREFERENCE_STRING));
			}
		}


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    //getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }
  
  @Override
  public void onLocationChanged(Location location) {
      LatLng defaultLocation = new LatLng(location.getLatitude(), location.getLongitude());
      CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(defaultLocation, 17);
      map.moveCamera(cameraUpdate);
      map.addMarker(new MarkerOptions().position(defaultLocation));
      locationManager.removeUpdates(this);
  }


@Override
public void onProviderDisabled(String provider) {
	// TODO Auto-generated method stub
	
}


@Override
public void onProviderEnabled(String provider) {
	// TODO Auto-generated method stub
	
}


@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
	// TODO Auto-generated method stub
	
}

} 
