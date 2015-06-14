package com.example.pi_android_app;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;


public class MainActivity extends Activity {

	//String http_url = "http://10.0.3.2/Example/Android/new_file.php"; // http://10.0.3.2/Example/Android/connect.to.db.php
	String http_url = "http://*********/read_pi_and_send_to_mysql.php";
	TextView textview_id_obj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		System.out.println("oncreate() is called");

		// As of to a certain version, Strick mode exception is thrown when an
		// application attempts to perform a networking operation in oncreate
		// method; so the following piece of code is required
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		textview_id_obj= (TextView) findViewById(R.id.textView_id);
		new helper_class(this, textview_id_obj).execute(http_url);
		
		//helper_class helper_class_obj = new helper_class();
		//TextView textview_id = (TextView) findViewById(R.id.textView_id);
		
		/*try {
			System.out.println("get_temprature_from_php_script is called ");

			String text = helper_class_obj.get_temprature_from_php_script(http_url);
			System.out.println("get_temprature_from_php_script called successfully");

			textview_id.setText(text);

			System.out.println("oncreate() succedded");

		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

}
