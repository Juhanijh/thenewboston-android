package com.k4sbasia;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlName, sqlHotness, sqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);

		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);

		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

		sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
		sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlGetInfo = (Button) findViewById(R.id.bGetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);

		sqlDelete.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSQLUpdate:
			String name = null;
			String hotness = null;

			boolean didItWork = true;
			try {
				name = sqlName.getText().toString();
				hotness = sqlHotness.getText().toString();

				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				e.printStackTrace();
			} finally {
				if (didItWork) {
					// Dialog
					// Dialog d = new Dialog(this);
					// d.setTitle("Heck Yea!");
					// TextView tv = new TextView(this);
					// tv.setText("Success");
					// d.setContentView(tv);
					// d.show();
					Toast.makeText(getApplicationContext(),
							"Heck Yea!" + name + " - " + hotness + " saved",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;

		case R.id.bSQLopenView:
			Intent i = new Intent("com.k4sbasia.SQLVIEW");
			startActivity(i);
			break;

		case R.id.bGetInfo:
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s);
			HotOrNot hon = new HotOrNot(this);
			hon.open();
			try {
				String returnedName = hon.getName(l);
				String returnedHotness = hon.getHotness(l);
				hon.close();
				sqlName.setText(returnedName);
				sqlHotness.setText(returnedHotness);
			} catch (Exception e) {
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				e.printStackTrace();
			}
			break;
		case R.id.bSQLmodify:
			String mName = sqlName.getText().toString();
			String mHotness = sqlHotness.getText().toString();
			String sRow = sqlRow.getText().toString();
			long lRow = Long.parseLong(sRow);

			HotOrNot ex = new HotOrNot(this);
			ex.open();
			try {
				ex.updateEntry(lRow, mName, mHotness);
			} catch (Exception e) {
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				e.printStackTrace();
			}

			ex.close();

			break;

		case R.id.bSQLdelete:
			String sRowDelete = sqlRow.getText().toString();
			long lRowDelete = Long.parseLong(sRowDelete);
			HotOrNot delete = new HotOrNot(this);
			delete.open();
			try {
				delete.deleteEntry(lRowDelete);
			} catch (Exception e) {
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang it!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				e.printStackTrace();
			}

			delete.close();

			break;
		}
	}
}
