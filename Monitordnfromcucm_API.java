package com.RestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Monitordnfromcucm_API {

	public static void main(String[] args)throws Exception{
		
		String valueString=null;
		
		StringBuilder response=new StringBuilder();
		URL url=new URL("http://192.168.1.237:8080/UniRSM_NCI/rest/app/monitordnfromcucm/8899/5000");
		
		HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		
		int response1=httpURLConnection.getResponseCode();
		if(response1==httpURLConnection.HTTP_OK)
		{
			BufferedReader b=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		while ((valueString=b.readLine())!=null)
		{
			response.append(valueString);
			
		}
		
		System.out.println("print  the value of Park DN : " + response);
		}
	}
}
