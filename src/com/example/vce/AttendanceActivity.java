package com.example.vce;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AttendanceActivity extends Activity  implements OnClickListener{

	static String sdata[];
	static String Slinks[];
	static String linkdata[]=new String[7];
	static String sem[]={"","","","","","",""};
	static int _count=0;
	static int _linkcount=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance);
		
		
		AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        
        parsedata();
        renmdersem();
        getlinks();
	}
	
	private void renmdersem() {
		
		TextView _td1=(TextView)findViewById(R.id.tb1t);
		TextView _td2=(TextView)findViewById(R.id.tb2t);
		TextView _td3=(TextView)findViewById(R.id.tb3t);
		TextView _td4=(TextView)findViewById(R.id.tb4t);
		TextView _td5=(TextView)findViewById(R.id.tb5t);
		TextView _td6=(TextView)findViewById(R.id.tb6t);
		TextView _td7=(TextView)findViewById(R.id.tb7t);
		
		_td1.setText(sem[0]);
		_td2.setText(sem[1]);
		_td3.setText(sem[2]);
		_td4.setText(sem[3]);
		_td5.setText(sem[4]);
		_td6.setText(sem[5]);
		_td7.setText(sem[6]);
	}

	public void parsedata()
	{
		try
		{
			TextView _td1=(TextView)findViewById(R.id.tb1d);
			TextView _td2=(TextView)findViewById(R.id.tb2d);
			TextView _td3=(TextView)findViewById(R.id.tb3d);
			TextView _td4=(TextView)findViewById(R.id.tb4d);
			TextView _td5=(TextView)findViewById(R.id.tb5d);
			TextView _td6=(TextView)findViewById(R.id.tb6d);
			TextView _td7=(TextView)findViewById(R.id.tb7d);
			
			if(sdata[0]!=null)
			{
			  _td1.setText(sdata[0].toString());
			}
			else
			 _td1.setText(" ");
				
			  
			if(sdata[1]!=null)
			{
			  _td2.setText(sdata[1].toString());
			}
			else
			 _td2.setText(" ");
			
			if(sdata[2]!=null)
			{
			  _td3.setText(sdata[2].toString());
			}
			else
			 _td3.setText(" ");
			if(sdata[3]!=null)
			{
			  _td4.setText(sdata[3].toString());
			}
			else
			 _td4.setText(" ");
			if(sdata[4]!=null)
			{
			  _td5.setText(sdata[4].toString());
			}
			else
			 _td5.setText(" ");
			if(sdata[5]!=null)
			{
			  _td6.setText(sdata[5].toString());
			}
			else
			 _td6.setText(" ");
			
			if(sdata[6]!=null)
			{
			  _td7.setText(sdata[6].toString());
			}
			else
			 _td7.setText(" ");

		}
		catch(Exception exp)
		{
			
		}
	}

	public void getlinks()
	{
		try{
			int i=0;
			if((Slinks[0]!=null))
			{
				for(String s : Slinks)	
				{
					linkdata[i++]=s.substring(7,38);
				}
			}
		}catch(Exception exp){
			
		}
	}

	public void Onclick_b1(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb1d);
		if(!t.getText().equals(""))
		{
			_linkcount=0;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}

	public void Onclick_b2(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb2d);
		if(!t.getText().equals(""))
		{
			_linkcount=1;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}

	public void Onclick_b3(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb3d);
		if(!t.getText().equals(""))
		{
			_linkcount=2;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}
	public void Onclick_b4(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb4d);
		if(!t.getText().equals(""))
		{
			_linkcount=3;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}
	public void Onclick_b5(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb5d);
		if(!t.getText().equals(""))
		{
			_linkcount=4;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}
	public void Onclick_b6(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb6d);
		if(!t.getText().equals(""))
		{
			_linkcount=5;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}
	public void Onclick_b7(View view)
	{
		TextView t=(TextView)findViewById(R.id.tb7d);
		if(!t.getText().equals(""))
		{
			_linkcount=6;
			Intent intent = new Intent(this, DetailedAttendanceActivity.class);
	        startActivity(intent);  
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
