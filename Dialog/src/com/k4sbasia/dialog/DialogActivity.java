package com.k4sbasia.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends Activity {
	
	private CharSequence[] items = {"Google", "Apple", "Microsoft"};
	boolean[] itemsChecked = new boolean[items.length];
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onClick(View v) {
    	showDialog(0);
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	switch (id) {
    	case 0: 
    		Builder builder = new AlertDialog.Builder(this);
    		builder.setIcon(R.drawable.ic_launcher);
    		builder.setTitle("This is a dialog with some simple text...");
    		builder.setPositiveButton("OK",
    				new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
						}
					});
    		
    		builder.setNegativeButton("Cancel", 
    				new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();							
						}
					});
    		
    		builder.setMultiChoiceItems(items, itemsChecked,
    				new DialogInterface.OnMultiChoiceClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							Toast.makeText(getBaseContext(), items[which] + (isChecked ? " checked!":" unchecked!"), Toast.LENGTH_SHORT).show();
						}
					});
    		return builder.create();
    	
    	case 1:
    		return new AlertDialog.Builder(this)
    		.setIcon(R.drawable.ic_launcher)
    		.setTitle("This is a dialog with some simple text...")
    		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
				}
			})
			.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					Toast.makeText(getBaseContext(), items[which] + (isChecked? " checked!" : " unchecked!"), Toast.LENGTH_SHORT).show();
				}
			}).create();
    	}
    	return null;    	
    }
}