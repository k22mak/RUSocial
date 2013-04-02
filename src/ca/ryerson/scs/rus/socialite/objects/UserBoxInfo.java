package ca.ryerson.scs.rus.socialite.objects;

import java.util.Date;

import com.google.android.gms.maps.model.LatLng;

public class UserBoxInfo {

	 

	 private LatLng latLong;

	 private String name;

	 private Date someDate;

	 private String type;

	 

	 public UserBoxInfo(LatLng latLong, String name, Date someDate, String type) {

	  super();

	  this.latLong = latLong;

	  this.name = name;

	  this.someDate = someDate;

	  this.type = type;

	 }

	 

	 public LatLng getLatLong() {

	  return latLong;

	 }

	 public void setLatLong(LatLng latLong) {

	  this.latLong = latLong;

	 }

	 public String getName() {

	  return name;

	 }

	 public void setName(String name) {

	  this.name = name;

	 }

	 public Date getSomeDate() {

	  return someDate;

	 }

	 public void setSomeDate(Date someDate) {

	  this.someDate = someDate;

	 }



	 public String getType() {

	  return type;

	 }



	 public void setType(String type) {

	  this.type = type;

	 }

	}
