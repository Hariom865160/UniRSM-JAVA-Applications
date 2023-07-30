package com.RestAPI;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class Moniter_API {

	
public static void main(String[] args) throws Exception {
		
		StringBuffer response = new StringBuffer();

	

		URL urlForGetRequest = new URL("http://192.168.1.237:8080/UniRSM/rest/app/monitordnfromcucm");

		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		conection.setRequestMethod("GET");

		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));

			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			System.out.println("Response Result is: " + (response.toString()));

			
//			 JSONObject jsonObject = new JSONObject(); jsonObject = (JSONObject) object;
//			  String data = jsonObject.get("internal_comment").toString(); String
//			  data2=jsonObject.get("cust_pweb_ref_no").toString();
//			  System.out.println("string : "+data);
//			  System.out.println("proint the data2:"+data2);
			 
			
	}
}
}
