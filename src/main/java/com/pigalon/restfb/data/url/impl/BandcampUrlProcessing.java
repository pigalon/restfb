package com.pigalon.restfb.data.url.impl;

import com.pigalon.restfb.data.url.UrlProcessing;

public class BandcampUrlProcessing implements UrlProcessing{

	public String idExtractionFromUrl(String strUrl) throws Exception {
		
		if(strUrl != null){
			
			int beginInd = strUrl.indexOf("://");
			int endInd = strUrl.indexOf(".bandcamp");
			
			if(beginInd >0 && endInd>0){
				strUrl = strUrl.substring(beginInd+3, endInd);
			}
		}
			
			
		return strUrl;
	}

}
