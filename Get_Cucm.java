package com.RestAPI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Get_Cucm {


	public static void main(String[] args) throws Exception {

	 StringBuilder response = new StringBuilder();

		URL urlForGetRequest = new URL("http://192.168.1.237:8080/UniRSM/rest/app/getCucmDetailsByPGID/5000");

		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		conection.setRequestMethod("GET");

		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));

			while ((readLine = in.readLine()) != null) 
			  { 
				  response.append(readLine);
				  }

		
			System.out.println("Response Result is: " + (response.toString()));

			
			
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(response.toString()));
		
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			 
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(is);  
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList nodeList = doc.getElementsByTagName("cucmConfig");  
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
			Node node = nodeList.item(itr); 
			Element eElement = (Element) node; 
			System.out.println(eElement.getElementsByTagName("primaryCucm").item(0).getTextContent());
			System.out.println(eElement.getElementsByTagName("primaryCucmIP").item(0).getTextContent());
			  
	}
		}
	}
}

