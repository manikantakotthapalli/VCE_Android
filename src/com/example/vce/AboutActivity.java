package com.example.vce;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
	}
	public void Onclick(View view)
	{
		
	}
	
	public void sendMail(View v)
	{
		try{
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("message/rfc822");
			intent.putExtra(Intent.EXTRA_EMAIL, "vcewin8app@gmail.com");
			intent.putExtra(Intent.EXTRA_SUBJECT, "VCE android app suggestion/BUG");
			intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

			startActivity(Intent.createChooser(intent, "Send Email....."));
		}
		catch(Exception exp)
		{
			
		}
	}
}
