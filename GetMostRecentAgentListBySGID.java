package com.RestAPI;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMostRecentAgentListBySGID {
	
	
	public static void main(String[] args)throws Exception
	{
		
		StringBuilder response=new StringBuilder();
		
		URL url=new URL("http://192.168.1.237:8080/UniRSM_NCI/rest/app/getMostRecentAgentListBySGID/5005");
			
		
		String value=null;
		HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		
		int response1=httpURLConnection.getResponseCode();
		if(response1==httpURLConnection.HTTP_OK)
		{
			BufferedReader b=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			
			while ((value=b.readLine())!=null)
			{
				response.append(value);
				
				
			}
			System.out.println("print the value of API:"+response.toString());
			
			
			String[] output = (response.toString()).split(",");

	        String part1 = output[0]; 
	        String part2 = output[1]; 
	        
	        System.out.println("Agent id: "+part1 );
	        System.out.println("Agent Skil team "+part2);
	        
	        
			
			
			
		}

	

}
}

