package com.k4sbasia;

import android.app.Activity;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.helloworld);
		setTitle("And the title has been set");
	}

}
