package com.example.vce;

import android.app.*;
import android.content.*;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

import com.example.vce.*;
import com.google.android.gms.ads.*;

public class Login extends Activity {

	public static String _userid;
	public static String _pswd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		AdView mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        
		addListenerOnButton();
	}
 
	public void addListenerOnButton() {
 
		final Context context = this;
 
		Button button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				try{
					EditText _usertb=(EditText) findViewById(R.id.user_tb);
					EditText _pswdtb=(EditText) findViewById(R.id.pswd_tb);
			        
					if(_usertb.getText().length()!=0 && _pswdtb.getText().length()!=0)
					{
						_userid=_usertb.getText().toString();
						_pswd=_pswdtb.getText().toString();
						
						Intent intent = new Intent(context, MainActivity.class);
	                           startActivity(intent);   
					}
					else
					{
						Alert();
				  }
				}
				catch(Exception exp)
				{
					
				}
			}
 
		});
 
	}	
	
	@SuppressWarnings("deprecation")
	public void Alert()
    { 
        AlertDialog dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("Missing some thing ;)");
        dialog.setMessage("please enter login id/password");
       
            dialog.setButton("OK",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            
                        }
                    });

        dialog.show();

    }
}
