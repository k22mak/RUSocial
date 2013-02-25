package ca.ryerson.scs.rus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequestAdapter {

	public static JSONObject httpRequest(String url,
			HashMap<String, String> inputs) {

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		for (Map.Entry<String, String> entry : inputs.entrySet()) {
			nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
		}

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse httpResponse = httpClient.execute(httpPost);

			HttpEntity httpEntity = httpResponse.getEntity();

			if (httpEntity != null) {
				httpEntity.toString();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						httpEntity.getContent()));

				StringBuilder fullResponse = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					fullResponse.append(line + "\n");
				}
				return (new JSONObject(fullResponse.toString()));
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static JSONObject httpRequest(String url) {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();

			if (httpEntity != null) {
				httpEntity.toString();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						httpEntity.getContent()));

				StringBuilder fullResponse = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					fullResponse.append(line + "\n");
				}
				return (new JSONObject(fullResponse.toString()));
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
