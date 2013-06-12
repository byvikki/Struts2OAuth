package com.struts.OAuth.AcessToken;

import java.io.*;
import java.util.*;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
public class GoogleAcess {
	
	
	public static String readFromUrl(String Url, String code){
		
		try{			
			HttpClient client = new DefaultHttpClient();
			
			HttpPost post = new HttpPost(Url);
			
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			
			
			nameValuePairs.add(new BasicNameValuePair("code", code));
			
			nameValuePairs.add( new BasicNameValuePair("client_id", "250936567640.apps.googleusercontent.com"));
			
			nameValuePairs.add(new BasicNameValuePair("client_secret","DPekHYu6yarOovrLaVJPJSlY"));
			
			nameValuePairs.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/Struts2OAuth2/hello?with=google"));
			
			nameValuePairs.add(new BasicNameValuePair("grant_type", "authorization_code"));
			
			
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			HttpResponse response = client.execute(post);
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line = "";
			
			String result = "";
			
			while((line = rd.readLine()) != null){
				
				result = result+ line;
				
			}
			
			
			return result;
			
		}
		catch(Exception e){
			System.out.println("Exception at readFromUrl "+e.toString());
			return e.toString();
		}
		
		
	}

}
