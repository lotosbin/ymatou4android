package test.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestJsonpClient {

	public static JSONArray JsonArrayConnect(String url) throws JSONException{
		String result = stringConnect(url);  
		JSONArray json = new JSONArray();
		json = new JSONArray(result.substring(1, result.length()-2));

		return json;
	}
	public static JSONObject connect(String url)

	{

		String result = stringConnect(url);  
		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(result.substring(1, result.length()-1));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;

	}

	public static String stringConnect(String url) {
		HttpClient httpclient = new DefaultHttpClient();

		// Prepare a request object

		HttpGet httpget = new HttpGet(url);

		// Execute the request

		HttpResponse response;

		
String result = null;
		try {

			response = httpclient.execute(httpget);

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				// A Simple JSON Response Read

				InputStream instream = entity.getContent();

				
				result = convertStreamToString(instream);

				
				instream.close();

			}

		} catch (ClientProtocolException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return result;
	}

	/**
	 * 62.
	 * 
	 * 63.
	 * 
	 * @param is
	 *            64.
	 * @return String 65.
	 */

	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = null;

		try {

			while ((line = reader.readLine()) != null) {

				sb.append(line + "\n");

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				is.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return sb.toString();

	}

}
