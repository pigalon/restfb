package com.pigalon.restfb.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class UrlTest {
	
	@Test
	public void urlprocessingTest(){
		String strUrl = "http://www.youtube.com/watch?v=TZpYTAICdbY&t=hotho,tho,t,h";
		
		try {
			URL url = new URL(strUrl);
			
			String query = url.getQuery();
			// get only v param from query
			// fisrt postion after v= and end nothing or &
			
			query = query.substring(query.indexOf("v=")+2);
			query = query.substring(query.indexOf("v=")+2);
			int cutEndFlag = query.indexOf("&");
			if(cutEndFlag > 0){
				query = query.substring(0, cutEndFlag);
			}
			
			System.out.println(query);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
