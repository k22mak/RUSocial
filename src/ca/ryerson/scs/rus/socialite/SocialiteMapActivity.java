package ca.ryerson.scs.rus.socialite;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import ca.ryerson.scs.rus.R;
import ca.ryerson.scs.rus.adapters.HttpRequestArrayAdapter;
import ca.ryerson.scs.rus.socialite.objects.UserBoxInfo;
import ca.ryerson.scs.rus.socialite.objects.ModifiedFragment;
import ca.ryerson.scs.rus.util.IntentRes;
import ca.ryerson.scs.rus.util.URLResource;
import ca.ryerson.scs.rus.util.ValidityCheck;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
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
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.socialize_map);

		context = this;
		mapFragment = new ModifiedFragment();

		FragmentTransaction ft = getFragmentManager().beginTransaction();

		ft.add(R.id.map, mapFragment);
		ft.commit();

		String URLfinal = ValidityCheck.whiteSpace(URLResource.LOOK_AROUND
				+ "?geoX=43.812" + "&geoY=-79.298");
		HttpRequestArrayAdapter.httpRequest(this, URLfinal, new MapHandler());

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);

	}

	@Override
	protected void onStart() {

		super.onStart();

		// setUpUsers();

	}

	@Override
	public void onLocationChanged(Location location) {
		LatLng defaultLocation = new LatLng(location.getLatitude(),
				location.getLongitude());
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				defaultLocation, 13);

		mapFragment.getMap().moveCamera(cameraUpdate);
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

	private class MapHandler implements HttpRequestArrayAdapter.ResponseHandler {

		@Override
		public void postResponse(JSONArray response) {
			JSONObject jd;
			infoBoxMap = new HashMap<String, UserBoxInfo>();

			for (int i = 0; i < response.length(); i++) {
				try {
					jd = response.getJSONObject(i);
					infoBox = new UserBoxInfo(new LatLng(Double.parseDouble(jd
							.getString("geoX")), Double.parseDouble(jd
							.getString("geoY"))), jd.getString("username"),
							jd.getString("email"), jd.getString("status"));
					infoMarker = mapFragment.placeMarker(infoBox);
					infoBoxMap.put(infoMarker.getId(), infoBox);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			infoMarker = mapFragment.placeMarker(infoBox);
			infoBoxMap.put(infoMarker.getId(), infoBox);

			mapFragment.getMap().setOnInfoWindowClickListener(
					new OnInfoWindowClickListener() {

						@Override
						public void onInfoWindowClick(Marker marker) {
							
							Intent showProfile = new Intent(IntentRes.PROFILE_STRING);
							showProfile.putExtra("username", infoBoxMap.get(marker.getId()).getUsername());
							showProfile.putExtra("email", infoBoxMap.get(marker.getId()).getEmail());
							showProfile.putExtra("status", infoBoxMap.get(marker.getId()).getStatus());
							
							context.startActivity(showProfile); 
							
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
					UserBoxInfo userInfo = infoBoxMap.get(marker.getId());

					String title = marker.getTitle();

					TextView txtTitle = ((TextView) contents
							.findViewById(R.id.tvTitle));

					if (title != null) {

						SpannableString titleText = new SpannableString(title);
						titleText.setSpan(new ForegroundColorSpan(Color.BLUE),
								0, titleText.length(), 0);
						txtTitle.setText(titleText);

					} else {
						txtTitle.setText("");
					}

					TextView txtType = ((TextView) contents
							.findViewById(R.id.tvStatus));
					txtType.setText(userInfo.getStatus());

					return contents;

				}

			});

		}

		@Override
		public void postTimeout() {
			// TODO Auto-generated method stub

		}

	}

}
