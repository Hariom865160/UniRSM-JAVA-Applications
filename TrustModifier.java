package com.RestAPI;

import java.net.HttpURLConnection;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import com.audium.server.session.DecisionElementData;

public class TrustModifier {
	
   private static final TrustingHostnameVerifier TRUSTING_HOSTNAME_VERIFIER = new TrustingHostnameVerifier();
   private static SSLSocketFactory factory;

   /** Call this with any HttpURLConnection, and it will
	modify the trust settings if it is an HTTPS connection. */
   
   public static void relaxHostChecking(HttpURLConnection conn) {
	   try {
		   if(conn instanceof HttpsURLConnection) {
		         HttpsURLConnection httpsConnection = (HttpsURLConnection) conn;
		         SSLSocketFactory factory = prepFactory(httpsConnection);
		         httpsConnection.setSSLSocketFactory(factory);
		         httpsConnection.setHostnameVerifier(TRUSTING_HOSTNAME_VERIFIER);
		   }
	   } catch(Exception e) {
		//   deData.addToLog("Exception Occurs: ", e.getMessage());
		   e.printStackTrace();		   
	   }
	   /*catch(KeyManagementException e) {
		   deData.addToLog("KeyManagementException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   } catch (NoSuchAlgorithmException e) {
		   deData.addToLog("NoSuchAlgorithmException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   } catch (KeyStoreException e) {
		   deData.addToLog("KeyStoreException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   }*/
   }

   static synchronized SSLSocketFactory prepFactory(HttpsURLConnection httpsConnection) { 
	   try {
		   if (factory == null) {
//		         SSLContext ctx = SSLContext.getInstance("TLS");
			   SSLContext ctx = SSLContext.getInstance("TLSv1.2");
//			   SSLContext ctx = SSLContext.getInstance("ssl3");
			   
		         
		         ctx.init(null, new TrustManager[]{ new AlwaysTrustManager() }, null);
		         factory = ctx.getSocketFactory();
		   }
	   } catch(KeyManagementException e) {
		  // deData.addToLog("KeyManagementException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   } catch (NoSuchAlgorithmException e) {
		   //deData.addToLog("NoSuchAlgorithmException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   } /*catch (KeyStoreException e) {
		   deData.addToLog("KeyStoreException Occurs: ", e.getMessage());
		   e.printStackTrace();
	   }*/
      
      return factory;
   }

   private static final class TrustingHostnameVerifier implements HostnameVerifier {
      public boolean verify(String hostname, SSLSession session) {
         return true;
      }
   }

   private static class AlwaysTrustManager implements X509TrustManager {
      public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException { }
      public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException { }
//      public X509Certificate[] getAcceptedIssuers() { return null; }
      public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
   }
}
