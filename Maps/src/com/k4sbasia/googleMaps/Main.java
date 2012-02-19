package com.k4sbasia.googleMaps;

import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class Main extends MapActivity {

	MapView map;
	long start;
	long stop;
	MapController mapController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		map = (MapView) findViewById(R.id.mvMain);

		map.setBuiltInZoomControls(true);

		Touchy t = new Touchy();
		List<Overlay> overlayList = map.getOverlays();
		overlayList.add(t);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	class Touchy extends Overlay {
		public boolean onTouchEvent(MotionEvent e, MapView m) {
			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				start = e.getEventTime();
			}
			if (e.getAction() == MotionEvent.ACTION_UP) {
				stop = e.getEventTime();
			}

			if (stop - start > 1500) {
				// perform an action
				AlertDialog alert = new AlertDialog.Builder(Main.this).create();
				alert.setTitle("Pick an Option");
				alert.setMessage("I told you to pick an action");
				alert.setButton("place a pinpoint",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});

				alert.setButton2("get address",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});

				alert.setButton3("poption 3",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						});

				alert.show();
				return true;
			}

			return false;
		}
	}
}