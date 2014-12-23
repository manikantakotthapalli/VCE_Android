package com.example.vce;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.*;

public class DetailedAttendanceActivity extends Activity {

	WebView _view=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed_attendance);
		
		AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        

        
        Thread t = new Thread(){public void run(){
            String ret = new AttendDetails().getDetails();
            
      }};
                   
      t.start();
      try {
		t.join();
		
		if(AttendDetails.doc!=null)
		{
			_view = (WebView) DetailedAttendanceActivity.this.findViewById(R.id._webview);
			_view.getSettings().setJavaScriptEnabled(true);
			 _view.loadDataWithBaseURL("", AttendDetails.doc.toString(), "text/html", "UTF-8", "");
			
		}
		
	} catch (Exception e) {
		
	}
	}
}
