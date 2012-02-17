package com.k4sbasia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class MyBringBack extends View {

	Bitmap gball;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(gball, (canvas.getWidth()/2), 0, null);
	}

	

}
