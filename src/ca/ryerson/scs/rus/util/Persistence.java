package ca.ryerson.scs.rus.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Persistence {

	private Persistence persistence;
	private static SharedPreferences preferences;
	private static SharedPreferences.Editor preferenceEditor;

	private static final String LOGIN_NAME = "loginName";
	private static final String PASSWORD = "password";

	private static final String DEFAULT_RETURN = "";

	private Persistence(Context context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		preferenceEditor = preferences.edit();
	}

	public Persistence getInstance(Context context) {
		if (persistence == null) {
			persistence = new Persistence(context);
		}
		return persistence;
	}

	public static void setLogin(String username) {
		preferenceEditor.putString(LOGIN_NAME, username);
	}

	public static String getLogin() {

		return preferences.getString(LOGIN_NAME, DEFAULT_RETURN);

	}

	public static void setPassword(String password) {
		preferenceEditor.putString(PASSWORD, password);
	}

	public static String getPassword() {

		return preferences.getString(PASSWORD, DEFAULT_RETURN);

	}

}
