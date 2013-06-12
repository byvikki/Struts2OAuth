package com.struts.OAuth.AcessToken;

import java.io.*;
import java.net.URI;
import java.util.*;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class fbAccess {

	//Facebook Access token with GET exchange authorization_code

	public static String readFromUrl(String Url, String code){

		try{			
			HttpClient client = new DefaultHttpClient();

			HttpPost post = new HttpPost(Url);

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);


			nameValuePairs.add(new BasicNameValuePair("code", code));

			nameValuePairs.add( new BasicNameValuePair("client_id", "185354518239982"));

			nameValuePairs.add(new BasicNameValuePair("client_secret","0be96db0a0c82b110a8803433646861d"));

			nameValuePairs.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/Struts2OAuth2/hello?with=fb"));

			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = client.execute(post);

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";

			String result = "";

			while((line = rd.readLine()) != null){

				result = result+ line;

			}
			result ="http://test.com?"+result;
			List<NameValuePair> pairs = URLEncodedUtils.parse(URI.create(result), "ISO-8859-1");
			result = pairs.get(0).getValue();			

			return result;

		}
		catch(Exception e){
			System.out.println("Exception at readFromUrl "+e.toString());
			return e.toString();
		}


	}
	
	public static String getUserInfo(String url, String access_token){
		String result = "";
		try{
			
			HttpClient client = new DefaultHttpClient();
			
			URIBuilder builder = new URIBuilder(url);
			
			builder.setParameter("access_token", access_token);
			
			
			HttpGet request = new HttpGet(builder.toString());
			
			HttpResponse response = client.execute(request);
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line = "";
			
			while (( line = rd.readLine()) != null){
				result = result+line;
			}
			
			return result;
			
		}
		
		catch(Exception e){
			result = e.toString();
			return result;			
		}
		
	}

}
