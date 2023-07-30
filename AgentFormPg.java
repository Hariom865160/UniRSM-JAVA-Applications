package com.RestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.sound.midi.Soundbank;

public class AgentFormPg {

	public static void main(String[] args)  throws Exception{
		
		String  string=null;
		
		StringBuilder  b=new StringBuilder();
		 URL url=new URL("http://192.168.1.237:8080/UniRSM_NCI/rest/app/agentsfrompg/5301");
		
		
		 String stringReader=null;
		 HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		
		 
		 httpURLConnection.setRequestMethod("GET");
		 int response =httpURLConnection.getResponseCode();
		 if(response ==httpURLConnection.HTTP_OK)
		 {
			 
			 BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

				while ((stringReader = in.readLine()) != null) {
					b.append(stringReader);
				}

				System.out.println("Agent form PG responseAPI "+  b);

				String[] output = b.toString().split(",");

		        //String part1 = output[0]; 
		        String part2 = output[1]; 
		        
		        //System.out.println("String 1: "+part1 );
		        System.out.println("string 2 :  "+part2);
		        
		
	}
	
	
	
}
}

