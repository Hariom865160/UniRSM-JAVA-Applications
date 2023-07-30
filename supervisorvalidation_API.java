package com.RestAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class supervisorvalidation_API {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


		 StringBuilder  response=new StringBuilder();
		 URL url=new URL("https://192.168.1.242:8445/finesse/api/User/5301");
		
		
		 String stringReader=null;
		 HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
		 TrustModifier.relaxHostChecking(httpURLConnection); 
		 String userCredentials ="5301" + ":" + "1234";
		 httpURLConnection.setRequestMethod("GET");
		 
		 
		 byte[] message = userCredentials.getBytes("UTF-8"); String encoded =
				  DatatypeConverter.printBase64Binary(message); 
				  String basicAuth = "Basic " +encoded ; 
				  httpURLConnection.setRequestProperty("Authorization", basicAuth);
				  
				  
				  
		 int response1 =httpURLConnection.getResponseCode();
		 if(response1 ==httpURLConnection.HTTP_OK)
		 {
			 
			 BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

				while ((stringReader = in.readLine()) != null) {
					response.append(stringReader);
				}

				System.out.println("print the value "+  response);

				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(response.toString()));
			
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
				 
				DocumentBuilder db = dbf.newDocumentBuilder();  
				Document doc = db.parse(is);  
				doc.getDocumentElement().normalize();  
				System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
				NodeList nodeList = doc.getElementsByTagName("Team"); 
			
			
				
				for (int itr = 0; itr < nodeList.getLength(); itr++)   
				{  
				Node node = nodeList.item(itr); 
				Element eElement = (Element) node;
				String team = eElement.getElementsByTagName("id").item(0).getTextContent();
				if(team!=null) {
					
					String teamint=String.valueOf(itr);
					System.out.println("Team "+teamint+" id "+team);
				}
//				sysout
//				System.out.println(" print  the id:"+);
			
				}
				
				
		 }
		 
		 
	}

}

