package com.k4sbasia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.util.Log;
import android.view.View;

public class MyBringBack extends View {

	Bitmap gball;
	float changinY;
	Typeface font;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		changinY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "G-Unit.TTF");
	}

	@Override
	protected void onDraw(final Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

		Paint textPaint = new Paint();
		textPaint.setARGB(80, 28, 180, 150);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);

		canvas.drawText("mybringback", canvas.getWidth() / 2, 200, textPaint);

		canvas.drawBitmap(gball, (canvas.getWidth() / 2), changinY, null);
		if (changinY < canvas.getHeight()) {
			changinY += 10;
			Log.d("test", "y" + changinY);
		} else {
			changinY = 0;
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}
}
