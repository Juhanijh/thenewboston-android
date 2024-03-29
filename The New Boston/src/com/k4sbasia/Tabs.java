package com.k4sbasia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	TabHost th;
	TextView showResults;
	long start, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);

		th = (TabHost) findViewById(R.id.tabhost);
		Button bStart = (Button) findViewById(R.id.btStartWatch);
		Button bStop = (Button) findViewById(R.id.btStopWatch);
		Button newTab = (Button) findViewById(R.id.btAddTab);
		showResults = (TextView) findViewById(R.id.tvShowResults);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);

		newTab.setOnClickListener(this);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("StopWatch");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab2");
		th.addTab(specs);

		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btAddTab:
			TabSpec ourSpec = th.newTabSpec("tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {

				@Override
				public View createTabContent(String tag) {
					TextView text = new TextView(Tabs.this);
					text.setText("You've created a new Tab...");
					return (text);
				}
			});

			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			break;

		case R.id.btStartWatch:
			start = System.currentTimeMillis();
			break;

		case R.id.btStopWatch:
			stop = System.currentTimeMillis();

			if (start != 0) {
				long result = stop - start;
				int millis = (int) result;
				int seconds = (int) result / 1000;
				int minutes = seconds / 60;
				millis = millis % 100;
				seconds = seconds % 60;

				showResults.setText(String.format("%d:%02d:%02d", minutes,
						seconds, millis));
			}
			break;
		}
	}
}
