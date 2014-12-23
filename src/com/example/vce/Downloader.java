package com.example.vce;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.R.bool;
import android.content.*;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class Downloader {
              
              private String url = "http://www.vce.ac.in/Index.aspx";
              private String username = "";
              private String password = "";
              Document doc=null;
              String x="";
              static boolean flag=true;
              String sdata[]=new String[30];
              String sdata1[]=new String[300];
              String ldata[]=new String[300];
              String semdata[]=new String[7];
              public static Map<String, String> cookies;
              public String DownloadHandler(){
                           try {
                        	   username=Login._userid;
                        	   password=Login._pswd;
	                                         Connection connection = Jsoup.connect(url).method(Method.GET);
	                                         Response response = connection.execute();
	                                         cookies = response.cookies();
	                                         doc = response.parse();
	                                         Element viewstateNode = doc.getElementById("__VIEWSTATE");
	                                         Element eventvalidationNode = doc.getElementById("__EVENTVALIDATION");
	                                         
	                                         String viewStateValue = viewstateNode.attr("value");
	                                         String eventValidationValue = eventvalidationNode.attr("value");
	                                         connection = Jsoup.connect(url)
                                                                       .data("__VIEWSTATE", viewStateValue)
                                                                       .data("__EVENTVALIDATION", eventValidationValue)
                                                                       .data("txtLoginID", username)
                                                                       .data("txtPWD", password)
                                                                       .data("btnLogin", "Go%21")
                                                                       .followRedirects(true)
                                                                       .userAgent("Google")
                                                                       .cookies(cookies)
                                                                       .maxBodySize(100000)
                                                                       .timeout(60000);
                                         response = connection.method(Method.POST).execute();
                                         doc = response.parse();

                                     
                                        Elements ele=doc.select("table");
                                        int c=0;
                                        Element _table=null;
                                        
                                        for (Element element : ele)
                                        {
                                        	_table=element;
	                                        	c++;
	                                        switch(c)
	                                        {
	                                        case 2:
	                                        	 StudentInformation(_table);
	                                        	break;
	                                        case 3:
	                                        	AttendanceDetails(_table);
	                                        	break;
	                                        }
	                                     
                                     }
                                       
                           } catch (Exception e)
                           {
                                  flag=false;
                           }
                           return null;
              }
              
              public void StudentInformation(Element table)
              {
            	  int count=0;
            	  try{
	            	  for(Element table1 : table.select("tr"))
	                  {
	                  	Elements data=table1.select("td");
	                  	for(Element _data : data)
	                  	{
	                  		sdata[count++]=_data.text();
	                  	}
	                  } 
	            	  count=0;
	            	  MainActivity.sdata=sdata;
	            	  
            	  }
            	  catch(Exception exp)
            	  {
            		  flag=false;
            	  }
              }
              
              public void AttendanceDetails(Element table) {
            	  int count=0;
            	  try{
            		  		Elements links = table.getElementsByTag("a");

                             for(Element link : links)
                             {
                            	 x=link.text();
                            	 if(!x.contains("View"))
                            	 {
		                  			sdata1[count]=link.text();
		                  			ldata[count]=link.attr("onclick").toString();
		                  			count++;
		                  			AttendanceActivity._count++;
                            	 }
	                  		}
	            	  
            	  }
            	  catch(Exception exp)
            	  {
            		  flag=false;
            	  }
				finally
				{
					AttendanceActivity.sdata=sdata1;
	            	AttendanceActivity.Slinks=ldata;
	            	  getsemdata(table);
				}
			}

			private void getsemdata(Element table) {
				
				try{
					int _count=0,j=0;
					for(Element tabl : table.select("tr"))
                    {
                    	Elements data=tabl.select("td");
                    	int i=0;
                    	for(Element ele : data)
                    	{
                    		j++;
                    		i++;
                    		if(i==3&&j>1)
                    		{
                    		semdata[_count++]=data.get(2).text()+" - "+data.get(3).text();
                    		break;
                    		}
                    	}
                    } 
				}
				catch(Exception exp)
				{
					flag=false;
				}
				finally
				{
					AttendanceActivity.sem=semdata;
				}
			}
			
			
}

