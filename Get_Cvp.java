package com.RestAPI;

import java.io.BufferedReader;



import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.lang.model.element.NestingKind;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Get_Cvp {

	public static void main(String[] args) throws Exception {

		StringBuilder response = new StringBuilder();

		URL urlForGetRequest = new URL("http://192.168.1.237:8080/UniRSM/rest/app/getcvpConfiguration");

		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		conection.setRequestMethod("GET");

		
		
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));

			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}

			System.out.println("Response Result is: " + (response.toString()));

		
			
			JSONParser parser = new JSONParser();
			Object object = parser.parse(response.toString());
		
			JSONObject jsonObject = new JSONObject();
			jsonObject = (JSONObject) object;
			Set<String> keySet=jsonObject.keySet();
			Iterator<String> keyIterator=keySet.iterator();
			while (keyIterator.hasNext())
					{
				
				String keyString=keyIterator.next();
				Object vaObject=jsonObject.get(keyString);
				System.out.println(keyString+"     "+vaObject );
				
				String call=keyString;
				
				
				if(call.equalsIgnoreCase("maxTransferTime "))
						{
					System.out.println("value:"+vaObject);
						}
				
		
				
					}
			 //String key=keyString;
			 //String value=vaObject;
				
				
			
					
//			jsonObject = (JSONObject) object;
//			String data = jsonObject.get("superUserID").toString();
//			System.out.println("string : " + data);
//			
//			
			
			
			
//			System.out.println("int " +String.valueOf(responseCode));
//			
//			
//			
//			if(responseCode==200)
//			{
//				System.out.println("success");
//				
//			}
//			else System.out.println("failure");
//			
//			
//			
//			
//			String[] output = key.split("\\|");
//
//	        String part1 = output[0]; 
//	        String part2 = output[1]; 
//	        
//	        System.out.println("String: "+part1 +" and "+part2);
//	        
					}
		}
	}
