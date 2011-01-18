package test.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class test extends TabActivity implements OnClickListener {
	// Implement the OnClickListener callback
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Button01: {
			String url = "http://www.ymatou.com/ajax/101100_1";
			String s = RestJsonpClient.stringConnect(url);
			TextView button = (TextView) findViewById(R.id.TextView01);
			if (s == null || s == "") {
				s = "empty";
			}
			button.setText(s);
		}
			break;
		case R.id.Button02:

		{
			String s = "";
			String url = "http://www.ymatou.com/ajax/101100_1";
			JSONArray jsons = new JSONArray();
			try {
				jsons = RestJsonpClient.JsonArrayConnect(url);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				s += e1.getMessage();
				e1.printStackTrace();
			}

			for (int i = 0; i < jsons.length(); i++) {
				try {
					JSONObject json = jsons.getJSONObject(i);
					String name = json.getString("name");
					String num = json.getString("num");
					s += name + "\t:" + num + "\n";
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					s += e.getMessage();
					e.printStackTrace();
				}
			}
			TextView button = (TextView) findViewById(R.id.TextView01);
			if (s == null || s == "") {
				s = "empty";
			}
			button.setText(s);
		}
			break;
		}
		// do something when the button is clicked

		// JSONObject o = RestJsonpClient.connect(url);
		// JSONObject json = o;
		// JSONArray nameArray = json.names();
		// JSONArray valArray;
		// try {
		// valArray = json.toJSONArray(nameArray);
		// for (int i = 0; i < valArray.length(); i++) {
		// Log.i("TAG", "<jsonname" + i + ">\n" + nameArray.getString(i)
		// + "\n</jsonname" + i + ">\n" + "<jsonvalue" + i + ">\n"
		// + valArray.getString(i) + "\n</jsonvalue" + i + ">");
		// }
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TabHost tabHost = getTabHost();

		LayoutInflater.from(this).inflate(R.layout.ranking,
				tabHost.getTabContentView(), true);
		tabHost.addTab(tabHost.newTabSpec("Home").setIndicator("Home")
				.setContent(R.id.LinearLayout02));
		tabHost.addTab(tabHost.newTabSpec("Friend").setIndicator("Friend")
				.setContent(R.id.LinearLayout02));
		tabHost.addTab(tabHost.newTabSpec("Topic").setIndicator("Topic")
				.setContent(R.id.LinearLayout02));
		tabHost.addTab(tabHost.newTabSpec("Activity").setIndicator("Activity")
				.setContent(R.id.LinearLayout02));
		tabHost.addTab(tabHost.newTabSpec("Ranking").setIndicator("Ranking")
				.setContent(R.id.LinearLayout01));
		// Resources res = getResources(); // Resource object to get Drawables
		// TabHost tabHost = getTabHost(); // The activity TabHost
		// TabHost.TabSpec spec; // Resusable TabSpec for each tab
		// Intent intent; // Reusable Intent for each tab
		//
		// // Create an Intent to launch an Activity for the tab (to be reused)
		// intent = new Intent().setClass(this, RankingActivity.class);
		//
		// // Initialize a TabSpec for each tab and add it to the TabHost
		// spec = tabHost.newTabSpec("artists").setIndicator("Artists",
		// res.getDrawable(R.drawable.ic_tab_artists))
		// .setContent(intent);
		// tabHost.addTab(spec);

		// Do the same for the other tabs
		// intent = new Intent().setClass(this, AlbumsActivity.class);
		// spec = tabHost.newTabSpec("albums").setIndicator("Albums",
		// res.getDrawable(R.drawable.ic_tab_albums))
		// .setContent(intent);
		// tabHost.addTab(spec);

		// intent = new Intent().setClass(this, SongsActivity.class);
		// spec = tabHost.newTabSpec("songs").setIndicator("Songs",
		// res.getDrawable(R.drawable.ic_tab_songs))
		// .setContent(intent);
		// tabHost.addTab(spec);

		// tabHost.setCurrentTab(0);

		Button button = (Button) findViewById(R.id.Button01);
		button.setOnClickListener((OnClickListener) this);

		Button button2 = (Button) findViewById(R.id.Button02);
		button2.setOnClickListener((OnClickListener) this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
		// return super.onCreateOptionsMenu(menu);
	}

}