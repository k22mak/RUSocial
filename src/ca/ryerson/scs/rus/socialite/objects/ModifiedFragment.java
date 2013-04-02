package ca.ryerson.scs.rus.socialite.objects;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ModifiedFragment extends MapFragment {

	 public Marker placeMarker(UserBoxInfo eventInfo) {

	  Marker m  = getMap().addMarker(new MarkerOptions()

	   .position(eventInfo.getLatLong())

	   .title(eventInfo.getName()));

	  

	  return m;

	 }

	}
