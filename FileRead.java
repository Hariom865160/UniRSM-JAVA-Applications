package com.RestAPI;

import java.util.Iterator;

public class FileRead {

	    public static void main(String[] args) {
	        String input = "{\"A\":\"B\",\"C\":\"D\"}";
	    
	    String valueString="U\"{\"agentPlatform\":\"Finesse\",\"customAPI_Protocol\":\"http\",\"hostname1\":\"192.168.1.237\",\"hostname2\":\"192.168.1.237\",\"maxTransferTime\":\"3600s\",\"multiPG\":\"false\",\"portName1\":\"8080\",\"portName2\":\"8080\",\"superUserID\":\"1001|1002|1003\"}\"";
	  //  public String getValues(String input) {
	    	
	    	// Remove leading and trailing braces
//	        String jsonString = input.substring(1, input.length() - 1);
//
//	        // Split the string by ","
//	        String[] keyValuePairs = jsonString.split(",");
//	        
//	        
//	        
//	        //for(int i =0;i<keyValuePairs.length;i++) {
//	        	
//	        //}
//
//	        // Extract values after ":"
//	        for (String keyValuePair : keyValuePairs) {
//	            String[] parts = keyValuePair.split(":");
//	            if (parts.length == 2) {
//	                String value = parts[1].replaceAll("\"", "");
//	                System.out.println(value);
//	            }
//	        }
//	        
	       // return "";
	       
	        
	        //String resString = "U\"Finesse\\\",http\\\",192.168.1.237\\\",192.168.1.237\\\",3600s\\\",false\\\",8080\\\",8080\\\",1001|1002|1003\\\"}\"";
	        String agentPlatform=valueString.substring(20, 27);
	        String customAPI_Protocol=valueString.substring(51, 55);
	        String hostname1=valueString.substring(70,83 );
	       String hostname2=valueString.substring(98, 111);
	       String maxTransferTime=valueString.substring(132, 137);
	       String multiPG=valueString.substring(150, 155);	       
	        
	       String portName1=valueString.substring(170, 174);
	       String portName2=valueString.substring(189, 193);
	       String superUserID=valueString.substring(210, 224);
	       
	    System.out.println("agentPlatform:"+agentPlatform);
	    System.out.println("customAPI_Protocol:"+customAPI_Protocol);
	    System.out.println("hostname1:"+hostname1);
	    System.out.println("hostname2:"+hostname2);
	    System.out.println("maxTransferTime:"+maxTransferTime);
	    System.out.println("multiPG:"+multiPG);
	    System.out.println("portName1:"+portName1);
	    System.out.println("portName2:"+portName2);
	    System.out.println("superUserID:"+superUserID);
	    
	    
	    String apiresopnseString="2:22:unirsm";
	    
	    String dataString=apiresopnseString.substring(0,1);
	    System.out.println(dataString);
	    
	    
	    String[] output = apiresopnseString.split(":");

        String part1 = output[0]; 
        String part2 = output[1]; 
        
        System.out.println("Agent id: "+part1 );
        System.out.println("Agent Skil team "+part2);
        
          
       
//        String  data= APIresponse ;
//        String[] data2=data.split(":");
//        monitoringMode =data2[0];
//        ParkDN =data2[1];
        
       String data ={"agentPlatform":"Finesse","customAPI_Protocol":"http"};//hostname1":"192.168.1.237","hostname2":"192.168.1.237","maxTransferTime":"3600s","multiPG":"false","portName1":"8080","portName2":"8080","superUserID":"1001|1002|1003"}";
        
        
        String[] dataStrings=data.substring(0, 0);
       String agentplatform=dataString[0];
       String customAPIString=dataString[1];
       System.out.println(agentPlatform);
       System.out.println(customAPIString);
       
//        }
//    
//       
//  
  
  
    
   
        
        
        
	    
	    }
	}


