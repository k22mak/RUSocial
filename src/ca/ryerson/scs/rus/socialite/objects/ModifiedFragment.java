package ca.ryerson.scs.rus.socialite.objects;

import ca.ryerson.scs.rus.R;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ModifiedFragment extends MapFragment {

	 public Marker placeMarker(UserBoxInfo eventInfo) {

	  Marker m  = getMap().addMarker(new MarkerOptions()

	   .position(eventInfo.getLatLong())

	   .title(eventInfo.getName()).icon(BitmapDescriptorFactory.fromResource(R.drawable.btn_lookclr)));

	  return m;

	 }

	}
