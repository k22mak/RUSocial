package ca.ryerson.scs.rus.socialite;

import java.util.Date;
import java.util.HashMap;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.socialite.objects.UserBoxInfo;
import ca.ryerson.scs.rus.socialite.objects.ModifiedFragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SocialiteMapActivity extends Activity implements LocationListener {

	private ModifiedFragment mapFragment;
	LocationManager locationManager;
	private static final long MIN_TIME = 400;
	private static final float MIN_DISTANCE = 1000;
	private HashMap<String, UserBoxInfo> infoBoxMap;
	private UserBoxInfo infoBox;
	private Marker infoMarker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.socialize_map);

		mapFragment = new ModifiedFragment();

		FragmentTransaction ft = getFragmentManager().beginTransaction();

		ft.add(R.id.map, mapFragment);
		ft.commit();

	}

	@Override
	protected void onStart() {

		super.onStart();

		setUpUsers();

	}

	private void setUpUsers() {

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

		infoBoxMap = new HashMap<String, UserBoxInfo>();

		infoBox = new UserBoxInfo(new LatLng(43.656, -79.390),
				"MARKER 1", new Date(), "MARKER 1");
		infoMarker = mapFragment.placeMarker(infoBox);
		infoBoxMap.put(infoMarker.getId(), infoBox);

		infoBox = new UserBoxInfo(new LatLng(43.653, -79.390), "MARKER 2",
				new Date(1032, 5, 25), "Convention");
		infoMarker = mapFragment.placeMarker(infoBox);
		infoBoxMap.put(infoMarker.getId(), infoBox);

		infoBox = new UserBoxInfo(new LatLng(43.625, -79.390), "MARKER 3", new Date(
				1032, 5, 25), "Event");
		infoMarker = mapFragment.placeMarker(infoBox);
		infoBoxMap.put(infoMarker.getId(), infoBox);

		mapFragment.getMap().setOnInfoWindowClickListener(
				new OnInfoWindowClickListener() {

					@Override
					public void onInfoWindowClick(Marker marker) {
						UserBoxInfo eventInfo = infoBoxMap.get(marker.getId());
						Toast.makeText(
								getBaseContext(),
								"The date of " + eventInfo.getName() + " is "
										+ eventInfo.getSomeDate(),
								Toast.LENGTH_LONG).show();
					}

				});

		mapFragment.getMap().setInfoWindowAdapter(new InfoWindowAdapter() {

			private final View contents = getLayoutInflater().inflate(
					R.layout.infowindow, null);

			@Override
			public View getInfoWindow(Marker marker) {

				return null;

			}

			@Override
			public View getInfoContents(Marker marker) {
				Log.i("MARKER ID PRESSED", "" + marker.getId());
				UserBoxInfo eventInfo = infoBoxMap.get(marker.getId());

				String title = marker.getTitle();

				TextView txtTitle = ((TextView) contents
						.findViewById(R.id.txtInfoWindowTitle));

				if (title != null) {

					// Spannable string allows us to edit the formatting of the
					// text.

					SpannableString titleText = new SpannableString(title);

					titleText.setSpan(new ForegroundColorSpan(Color.RED), 0,
							titleText.length(), 0);

					txtTitle.setText(titleText);

				} else {

					txtTitle.setText("");

				}

				TextView txtType = ((TextView) contents
						.findViewById(R.id.txtInfoWindowEventType));

				txtType.setText(eventInfo.getType());

				return contents;

			}

		});

	}

	@Override
	public void onLocationChanged(Location location) {
		LatLng defaultLocation = new LatLng(location.getLatitude(),
				location.getLongitude());
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				defaultLocation, 13);

		mapFragment.getMap().moveCamera(cameraUpdate);
		// mapFragmm.addMarker(new
		// MarkerOptions().position(defaultLocation).icon(
		// BitmapDescriptorFactory.fromResource(R.drawable.btn_lookclr)));
		locationManager.removeUpdates(this);

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
