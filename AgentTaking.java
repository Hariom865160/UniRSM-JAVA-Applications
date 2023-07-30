package com.RestAPI;

import java.io.BufferedReader;



import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class AgentTaking {
	
	public static void main(String[] args)throws Exception {
		
		String extString="7209";
		//String APIURL="https://192.168.1.242:8445/finesse/api/User/5202";
		String APIURL1="https://192.168.1.83/finesse/api/Users";
		  String value=null; 
		  StringBuilder response= new StringBuilder(); 
		  URL url=new  URL(APIURL1);
		  
		  HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		  TrustModifier.relaxHostChecking(httpURLConnection); 
		//String userCredentials ="5202" + ":" + "1234";
		  
		 String userCredentials ="admin" + ":" + "cons@123";
		  
		  
		  byte[] message = userCredentials.getBytes("UTF-8");
		  String encoded =
		  DatatypeConverter.printBase64Binary(message); 
		  String basicAuth = "Basic " +encoded ; 
		  httpURLConnection.setRequestProperty("Authorization", basicAuth);
		  
		  
		 int response1=httpURLConnection.getResponseCode();
		  if(response1==httpURLConnection.HTTP_OK) {
			  BufferedReader b=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		  
		  while((value=b.readLine())!=null) {
			  response.append(value); }
		 // System.out.println(" print the response value API Code:"+response); 
		  
		  
//		  InputSource is = new InputSource();
//			is.setCharacterStream(new StringReader(response.toString()));
//			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			
			InputSource inputSource = new InputSource(new StringReader(response.toString()));
			Document document = builder.parse(inputSource);

			// Get the list of all User elements
			NodeList userList = document.getElementsByTagName("User");

			// Iterate through each User element
			for (int i = 0; i < userList.getLength(); i++) {
				Element userElement = (Element) userList.item(i);

				// Get the state element
				Element extElement = (Element) userElement.getElementsByTagName("extension").item(0);
				String ext = extElement.getTextContent();
				//System.out.println("Extension:"+ext);

				// Check if the state is "READY"
				if (ext.equals(extString)) {
					// Get the loginId and extension elements
					Element stateElement = (Element) userElement.getElementsByTagName("state").item(0);
			String extensionElement = (String) userElement.getElementsByTagName("extension").item(0).getTextContent();
System.out.println("Extension:"+extensionElement);
					String stateReceive = stateElement.getTextContent();
					System.out.println("Sate:"+stateReceive);
					
			
		
//			
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
//			 
//			DocumentBuilder db = dbf.newDocumentBuilder();  
//			Document doc = db.parse(is);  
//			doc.getDocumentElement().normalize();  
//			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
//			NodeList nodeList = doc.getElementsByTagName("User");  
//			for (int itr = 0; itr < nodeList.getLength(); itr++)   
//			{  
//			Node node = nodeList.item(itr); 
//			Element eElement = (Element) node;
//
//			
//			System.out.println("State:            "+eElement.getElementsByTagName("state").item(0).getTextContent());
//			System.out.println("Extension:               "+eElement.getElementsByTagName("extension").item(0).getTextContent());
			
			//System.out.println( "Team is:"+eElement.getElementsByTagName("teamId").item(0).getTextContent());
			//System.out.println("Agent id:"+eElement.getElementsByTagName("loginId").item(0).getTextContent());
			
			
//			String extension=(eElement.getElementsByTagName("extension").item(0).getTextContent());
//			
//			String id="7209";
//		
//			String state=(eElement.getElementsByTagName("state").item(0).getTextContent());
//			
//			  if(id.equalsIgnoreCase(extension)&& state.equalsIgnoreCase("NOT_READY") )
//			  {
//				  System.out.println("Success");
//			  }
//			  else {
//				System.out.println("not match");
//			}
//			String teamint="";
//			for (int teamvalue = Integer.valueOf(teamint), i = 0; i <= teamvalue; ++i) {
//                String Teamid = (deData.getSessionData("Team" + i) != null) ? deData.getSessionData("Team" + i).toString().trim() : "";
//                deData.addToLog("Teamid", Teamid);
//                if (eElement.getElementsByTagName("teamId").item(0).getTextContent().equalsIgnoreCase(Teamid)) {
//                    deData.addToLog("adtologs valid resone", "Compareing Data");
//                    exitState = "TeamId true";
//                    if (eElement.getElementsByTagName("state").item(0).getTextContent().equalsIgnoreCase("Talking")) {
//                        exitState = "Success";
//                    }
//                    else {
//                        exitState = "NotTakingState";
//                    }
//                }
//                else {
//                    exitState = "TeamId  false";
//                }
//			
//		  
		  
		  }
		
			
			

			

			}
			
			
			
			
			
		
		
		
		
		
		
//		StringBuilder str = new StringBuilder();	
//		BufferedReader br = null;
//		
//		URL urlForGetRequest = new URL("https://192.168.1.242:8445/finesse/api/User/5202");
//		//deData.addToLog("Url value:", urlForGetRequest.toString());
//		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        TrustModifier.relaxHostChecking(conection);
//		conection.setRequestMethod("GET");
//		
//		
//		String userCredentials = "5202" + ":" + "1234";
//        
//        byte[] message = userCredentials.getBytes("UTF-8");
//		String encoded = DatatypeConverter.printBase64Binary(message);			
//		String basicAuth = "Basic " + encoded ;
//		conection.setRequestProperty("Authorization", basicAuth);
//		
//		int responseCode = conection.getResponseCode();
//		if (responseCode == HttpURLConnection.HTTP_OK) {
//
//			br = new BufferedReader(new InputStreamReader(conection.getInputStream()));
//            
//			 String responsebody, outputstring = "";
//		     	while ((responsebody=br.readLine())!=null) {
//		     		outputstring=responsebody;
//		     	}
//   	     	System.out.println("API respose is : "+outputstring);
//	
//   	     InputSource is = new InputSource();
//			is.setCharacterStream(new StringReader(outputstring));
//		
//			
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
//			 
//			DocumentBuilder db = dbf.newDocumentBuilder();  
//			Document doc = db.parse(is);  
//			doc.getDocumentElement().normalize();  
//			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
//			NodeList nodeList = doc.getElementsByTagName("User");  
//			for (int itr = 0; itr < nodeList.getLength(); itr++)   
//			{  
//			Node node = nodeList.item(itr); 
//			Element eElement = (Element) node; 
//			System.out.println(eElement.getElementsByTagName("extension").item(0).getTextContent());
//			System.out.println(eElement.getElementsByTagName("state").item(0).getTextContent());
//			  
		
			
//			int TIME = 5000; //5000 ms (5 Seconds)
//
//			new Handler().postDelayed(new Runnable() {
//			    @Override
//			    public void run() {
//
//			        function(); //call function!
//
//			    }
//			}, TIME);
	}

	}
}

