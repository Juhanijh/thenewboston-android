package com.k4sbasia.activity101;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class Activity101Activity extends Activity {
	
	private String tag = "Lifecycle";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.main);
        Log.d(tag, "In the onCreate() event");
    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	Log.d(tag, "In the onStart() event");
    }
    
    @Override
    public void onRestart() {
    	super.onRestart();
    	Log.d(tag, "In the onRestart() event");
    }
    
    @Override
    public void onResume() {
    	super.onRestart();
    	Log.d(tag, "In the onResume() event");
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	Log.d(tag, "In the onPause() event");
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	Log.d(tag, "In the onStop() event");
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	Log.d(tag, "In the onDestroy() event");
    }
}