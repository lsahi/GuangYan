package com.servlet;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserOpenServlet {
	
	BrowserOpenServlet(String ID) throws IOException, URISyntaxException {  
	    	//web URI
	        String website = "http://localhost:8080/GuangyanAdmin/edit.do?";
	        website=website+"Sno="+ID;
	        OpenBroswer(website);  
	    }   	
	      
	    public static void OpenBroswer(String webSite) throws URISyntaxException,  
	            IOException {  
	        Desktop desktop = Desktop.getDesktop();  
	        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {  
	            URI uri = new URI(webSite);  
	            desktop.browse(uri);  
	        }  
	    }  
}

  

