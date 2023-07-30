package com.RestAPI;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//import org.json.JSONArray;  
//import org.json.JSONObject;  

public class Test {

	public static void main(String[] args) throws Exception {

		StringBuilder b = new StringBuilder();
		BufferedReader b1 = null;

		URL url = new URL("http://192.168.1.237:8080/UniRSM/rest/app/getFinessePGMapping");

		HttpURLConnection Connection = (HttpURLConnection) url.openConnection();

		Connection.setRequestMethod("GET");
		// Connection.setRequestProperty("Content-Type", "application/Json");

		int response = Connection.getResponseCode();

		if (response == HttpURLConnection.HTTP_OK) {

			b1 = new BufferedReader(new InputStreamReader(Connection.getInputStream()));

//            String string = System.getProperty("line.separator");
			String string = " ";

			Scanner scanner = new Scanner(b1);

			while (scanner.hasNextLine()) {
				b.append(scanner.nextLine() + string);

				String response1 = b.toString();
				System.out.println("print the APi respone:" + response1);

				JSONParser parser = new JSONParser();
				Object object = parser.parse(response1);

				
				
				
				 JSONObject jsnobject = new JSONObject();  
			        //Printing JSON object  
			        System.out.println("JSON Object");  
			        System.out.println(jsnobject);  
			        //Getting languages JSON array from the JSON object  
			        JSONArray jsonArray =  jsnobject.getJSONArray();  
			        //Printing JSON array  
			        System.out.println("JSON Array");  
			        System.out.println(jsonArray);  
			        //Creating an empty ArrayList of type Object  
			        ArrayList<Object> listdata = new ArrayList<Object>();  
			          
			        //Checking whether the JSON array has some value or not  
			        if (jsonArray != null) {   
			              
			            //Iterating JSON array  
			            for (int i=0;i<jsonArray.length();i++){   
			                  
			                //Adding each element of JSON array into ArrayList  
			                listdata.add(jsonArray.get(i));  
			            }   
			        }  
			        //Iterating ArrayList to print each element  
			  
			        System.out.println("Each element of ArrayList");  
			        for(int i=0; i<listdata.size(); i++) {  
			            //Printing each element of ArrayList  
			            System.out.println(listdata.get(i));  
			
//				 JSONObject jsonObject = new JSONObject();
//				jsonObject = (JSONObject) object;
////				
//				JSONArray array = new JSONArray();
//				array = (JSONArray) object;
//				System.out.println(array);
//				
//				JSONObject json = new JSONObject();   
//		          
//		      
//		        JSONArray jsonArray = json.getJSONArray("");  
//				
				
				
			
		
//			Array data = array.get ;
//
//				System.out.println("string : " + data);

				}

			}

		}

}
}
	
