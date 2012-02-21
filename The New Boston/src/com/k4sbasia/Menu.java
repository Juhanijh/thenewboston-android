package com.k4sbasia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "TheNewBostonActivity", "Text", "HelloWorldActivity",
			"Email", "Camera", "Data", "GFX", "Splash", "GFXSurface",
			"SoundStuff", "Slider", "Tabs", "Browser", "Flipper",
			"SharedPrefs", "InternalData", "ExternalData", "SQLiteExample",
			"Accelerate", "HttpExample" };

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub

		super.onListItemClick(l, v, position, id);

		String menuItem = classes[position];

		try {
			Class ourClass = Class.forName("com.k4sbasia." + menuItem);
			Intent intent = new Intent(Menu.this, ourClass);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// full screen
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.k4sbasia.ABOUT");
			startActivity(i);

			break;

		case R.id.preferences:
			Intent p = new Intent("com.k4sbasia.PREFS");
			startActivity(p);
			break;

		case R.id.exit:
			finish();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}

		return false;
	}

}
