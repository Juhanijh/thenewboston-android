package com.k4sbasia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TheNewBostonActivity extends Activity {

	int counter;
	Button add, sub, menu;
	TextView display;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		counter = 0;
		add = (Button) findViewById(R.id.bAdd);
		sub = (Button) findViewById(R.id.bSub);
		menu = (Button) findViewById(R.id.bMenu);

		display = (TextView) findViewById(R.id.tvTotal);

		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				display.setText("Your total is: " + ++counter);

			}
		});

		sub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				display.setText("Your total is: " + --counter);

			}
		});

		menu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openStartingPoint = new Intent("com.k4sbasia.MENU");
				startActivity(openStartingPoint);
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}