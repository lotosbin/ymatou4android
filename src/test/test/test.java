package test.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class test extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.Button01);
		button.setOnClickListener((OnClickListener) this);
	}

	// Implement the OnClickListener callback
	public void onClick(View v) {
		// do something when the button is clicked
		String url = "http://www.ymatou.com/ajax/101100_1";
		String s = RestJsonpClient.stringConnect(url);
		TextView button = (TextView) findViewById(R.id.TextView01);
		if(s==null || s==""){
			s = "empty";
		}
		button.setText(s);
//		JSONObject o = RestJsonpClient.connect(url);
//		JSONObject json = o;
//		JSONArray nameArray = json.names();
//		JSONArray valArray;
//		try {
//			valArray = json.toJSONArray(nameArray);
//			for (int i = 0; i < valArray.length(); i++) {
//				Log.i("TAG", "<jsonname" + i + ">\n" + nameArray.getString(i)
//						+ "\n</jsonname" + i + ">\n" + "<jsonvalue" + i + ">\n"
//						+ valArray.getString(i) + "\n</jsonvalue" + i + ">");
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
		//return super.onCreateOptionsMenu(menu);
	}

}