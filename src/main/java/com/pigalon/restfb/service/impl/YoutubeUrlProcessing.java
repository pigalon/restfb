package com.pigalon.restfb.service.impl;

import java.net.URL;


import com.pigalon.restfb.service.UrlProcessing;

public class YoutubeUrlProcessing implements UrlProcessing {

	public String idExtractionFromUrl(String strUrl) throws Exception{
		String query = null;
		if(strUrl != null){
			URL url = new URL(strUrl);
			query = url.getQuery();
			// get only v param from query
			// fisrt postion after v= and end nothing or &
			
			query = query.substring(query.indexOf("v=")+2);
			int cutEndFlag = query.indexOf("&");
			if(cutEndFlag > 0){
				query = query.substring(0, cutEndFlag);
			}
		}
		else{
			throw new Exception("url is null");
		}
		
		return query;
	}

}
