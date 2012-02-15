package com.k4sbasia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash);
		ourSong.start();
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent("com.k4sbasia.MENU");
					startActivity(openStartingPoint);
				}
			}
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
