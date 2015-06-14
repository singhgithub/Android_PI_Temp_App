package com.example.pi_android_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;


public class helper_class extends AsyncTask<String, String, String>{
	//need these declaration case the parameters has to be stored in some var/obj 
	Context context;
	TextView textview_id;
	
	//create a construtor so that this helper_Class can use the activity class & textview  as parameter 
	//when the class is called in the acivity class
	helper_class(Context c, TextView t){
		this.context = c;
		this.textview_id = t;
		
	}
	
	@Override
	protected String doInBackground(String... params) {
		String get_url_obj = params[0];
		String return_string_obj =get_temprature_from_php_script(get_url_obj);
	
		return return_string_obj;
	}
	
	
	 @Override
	   protected void onPostExecute(String result){
	      this.textview_id.setText(result);
	   }
	
	
	public String get_temprature_from_php_script(String url1) {
		HttpURLConnection con = null;
		URL url;
		InputStream is = null;
		StringBuilder sb = null;

		try {
			// setting up a httpurl connection (section)
			url = new URL(url1);
			con = (HttpURLConnection) url.openConnection();
			con.setReadTimeout(10000 /* milliseconds */);
			con.setConnectTimeout(15000 /* milliseconds */);
			con.setRequestMethod("GET");
			con.setDoInput(true);
			// Start the query
			con.connect();

			// web data as a long string (section)
			is = con.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			sb = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			is.close();
			//connected.setText("Connection Succeded"); // should see this, if the
														// function ran proberly
			System.out.println("DownloadURL() did not throw a exception...");
		} catch (IOException e) {
			// handle the exception !
			e.printStackTrace();
			System.out.println("DownloadURL() throw a exception... can't connect to the server URL");
		}

		return sb.toString();
		
	}

	
	/*public String get_temp_from_openweathermap(){
		
		
		
	}*/

	
	

}
