package com.k4sbasia;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener {

	EditText url;
	WebView ourBrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		ourBrow = (WebView) findViewById(R.id.wvBrowser);

		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);

		ourBrow.setWebViewClient(new OurViewClient());
		try {
			ourBrow.loadUrl("http://www.youtube.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button clearHistory = (Button) findViewById(R.id.bHistory);

		url = (EditText) findViewById(R.id.etURL);

		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clearHistory.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			Log.d("browser", theWebsite);
			ourBrow.loadUrl(theWebsite);

			// hide the keyboard after using on EditText
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if (ourBrow.canGoBack()) {
				ourBrow.goBack();
			}
			break;
		case R.id.bForward:
			if (ourBrow.canGoForward()) {
				ourBrow.goForward();
			}
			break;
		case R.id.bRefresh:
			ourBrow.reload();
			break;
		case R.id.bHistory:
			ourBrow.clearHistory();
			break;
		}
	}
}
