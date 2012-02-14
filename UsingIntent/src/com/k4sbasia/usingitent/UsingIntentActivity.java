package com.k4sbasia.usingitent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UsingIntentActivity extends Activity {
	
	int requestCode = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onClick(View view) {
    	//startActivity(new Intent("com.k4sbasia.usingitent.SecondActivity"));
    	//startActivity(new Intent(this, SecondActivity.class));
    	startActivityForResult(new Intent("com.k4sbasia.usingitent.SecondActivity"), requestCode);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == this.requestCode) {
    		if (resultCode == RESULT_OK) {
    			Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
    		}
    	}
    }
}