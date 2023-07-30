package com.RestAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SupervisorfinesseD {
    

    public static void main(String[] args) throws Exception {

BufferedReader br = null;
        
        URL urlForGetRequest = new URL("http://192.168.1.237:8080/UniRSM_NCI/rest/app/supervisorfinesse/5000");
        
      System.out.println("Url value:"+urlForGetRequest.toString());
        HttpURLConnection conection = (HttpURLConnection)urlForGetRequest.openConnection();
       conection.setRequestMethod("GET");
       
        int responseCode = conection.getResponseCode();
       if (responseCode == 200) {
           br = new BufferedReader(new InputStreamReader(conection.getInputStream()));
           
           String outputstring = "";
           String responsebody;
           while ((responsebody = br.readLine()) != null) {
               outputstring = responsebody;
           }
          
          System.out.println("Api Response:"+outputstring );
          
          InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(outputstring));
		
   
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Get Document
            Document document = builder.parse(is);

            // Normalize the xml structure
            document.getDocumentElement().normalize();

            // Get all the element by the tag name

            NodeList list =  document.getElementsByTagName("primaryFinesse");
            for(int i = 0; i <list.getLength(); i++) {
                Node node1 = list.item(i);
                if(node1.getNodeType() == Node.ELEMENT_NODE) {

                    Element laptopElement = (Element) node1;
                    System.out.println("FinesseDetails: " + laptopElement.getAttribute(""));

                    NodeList Details =  node1.getChildNodes();
                    for(int j = 0; j < Details.getLength(); j++){
                        Node detail = Details.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            //System.out.println("PRI" + detailElement.getTagName() + ": " + detailElement.getTextContent());
                            
                           String key=detailElement.getTagName();
                           String value=detailElement.getTextContent();
                           
                            
                           System.out.println(key+" :"+value);
                            
                        }
                    }
                }
            }
            
        
                     //System.out.println("secondaryFinesse ");
                        
                        NodeList List = document.getElementsByTagName("secondaryFinesse");
                        for(int i1 = 0; i1 <List.getLength(); i1++) {
                            Node node = List.item(i1);
                            if(node.getNodeType() == Node.ELEMENT_NODE) {

                                Element element = (Element) node;
                                System.out.println("FinesseDetails: " + element.getAttribute(""));

                                NodeList Details =  node.getChildNodes();
                                for(int k = 0; k < Details.getLength(); k++){
                                    Node detail1 = Details.item(k);
                                    if(detail1.getNodeType() == Node.ELEMENT_NODE) {
                                        Element detailElement1 = (Element) detail1;
                                        System.out.println("SEC" + detailElement1.getTagName() + ": " + detailElement1.getTextContent());
                                    }
                
                                }
                            }
                        }
        }           
                      
         catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
      
    }
}


    











