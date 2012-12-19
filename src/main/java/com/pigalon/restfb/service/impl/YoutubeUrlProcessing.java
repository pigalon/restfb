package com.pigalon.restfb.service.impl;

import java.net.URL;


import com.pigalon.restfb.service.UrlProcessing;

public class YoutubeUrlProcessing implements UrlProcessing {

	public String idExtractionFromUrl(String strUrl) throws Exception{
		String query = null;
		if(strUrl != null){
			URL url = new URL(strUrl);
			
			// get the query where appear the id movie
			query = url.getQuery();
			
			// we need only v param from query
			// fisrt postion after v= and end nothing or &
			// if no param skip this processing and return null 
			if(query!=null){
				query = query.substring(query.indexOf("v=")+2);
				int cutEndFlag = query.indexOf("&");
				if(cutEndFlag > 0){
					query = query.substring(0, cutEndFlag);
				}
			}
			else{
				throw new Exception("no query to process");
			}
		}
		return query;
	}

}
