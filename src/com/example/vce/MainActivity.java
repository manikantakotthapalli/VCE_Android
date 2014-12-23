package com.example.vce;

import java.util.*;
import java.io.*;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.jsoup.*;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.DocumentsContract.Document;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity  {


	String html;
	static String sdata[];
	org.jsoup.nodes.Document doc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			if (android.os.Build.VERSION.SDK_INT > 9) {
			    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			    StrictMode.setThreadPolicy(policy);
			}
			
			AdView mAdView = (AdView) this.findViewById(R.id.adView);
	        AdRequest adRequest = new AdRequest.Builder().build();
	        mAdView.loadAd(adRequest);
			
	      
			
			Thread t = new Thread(){public void run(){
	            String ret = new Downloader().DownloadHandler();
	            
	      }};
	                   
	      t.start();
		 t.join();
		 if(Downloader.flag)
		 AppendDeatils();
		 else
		 {
			 Alert();
			 
		 }
	} catch (Exception e)
		{
			Alert();
	 }
		
	}
	public  void AppendDeatils() {
		try{
		// Name
		TextView _n=(TextView)findViewById(R.id.namet);
		_n.setText(sdata[4].toString());
		TextView _nd=(TextView)findViewById(R.id.named);
		_nd.setText(sdata[5]);
		
		// Roll number
		TextView _htt=(TextView)findViewById(R.id.halltickett);
		_htt.setText(sdata[2].toString());
		TextView _htd=(TextView)findViewById(R.id.hallticketd);
		_htd.setText(sdata[3].toString());
		
		//fn
		TextView _fnt=(TextView)findViewById(R.id.fnt);
		_fnt.setText(sdata[8].toString());
		TextView _fnd=(TextView)findViewById(R.id.fnd);
		_fnd.setText(sdata[9].toString());
		
		//dob
		TextView _dobt=(TextView)findViewById(R.id.dobt);
		_dobt.setText(sdata[6].toString());
		TextView _dobd=(TextView)findViewById(R.id.dobd);
		_dobd.setText(sdata[7].toString());
		
		
		//admission date
		TextView _addt=(TextView)findViewById(R.id.adatet);
		_addt.setText(sdata[12].toString());
		TextView _addd=(TextView)findViewById(R.id.adated);
		_addd.setText(sdata[13].toString());
		
	
		
		//branch-year-sem
		TextView _bys=(TextView)findViewById(R.id.yst);
		_bys.setText(sdata[14].toString());
		TextView _bysd=(TextView)findViewById(R.id.ysd);
		_bysd.setText(sdata[15]+": "+sdata[17]+"-"+sdata[19].toString());
		
		
		
		//current ststus
		
		TextView _cst=(TextView)findViewById(R.id.cst);
		_cst.setText(sdata[20].toString());
		TextView _csd=(TextView)findViewById(R.id.csd);
		_csd.setText(sdata[21].toString());
		
	
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}


	// Image onclickevent
	public void Onclick(View view)
	{
		Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);   
	}
	
	public void Onclicknext(View view)
	{
		Intent intent = new Intent(this, AttendanceActivity.class);
        startActivity(intent);   
	}

	public void toHome()
	{
		Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); 
	}
	@SuppressWarnings("deprecation")
	public void Alert()
    { 
        AlertDialog dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("Some thing went wrong");
        dialog.setMessage("Possible Internet/Server Issue. Please try again...");
       
            dialog.setButton("OK",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                        	toHome();
                        }
                    });

        dialog.show();
        
    }
}
