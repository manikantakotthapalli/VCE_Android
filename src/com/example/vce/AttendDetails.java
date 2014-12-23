package com.example.vce;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

public class AttendDetails {
	
	public static Document doc=null;
	public String getDetails()
	{
		try{
			String url="http://www.vce.ac.in/"+AttendanceActivity.linkdata[AttendanceActivity._linkcount];
			Connection connection = Jsoup.connect(url)
					.cookies(Downloader.cookies)
					.userAgent("Google")
                    .maxBodySize(100000)
                    .timeout(60000)
                    .method(Method.GET);
			 Response response = connection.execute();
             doc = response.parse();
             
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return null;
	}

}
