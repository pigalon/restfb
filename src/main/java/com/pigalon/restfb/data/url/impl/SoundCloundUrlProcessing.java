package com.pigalon.restfb.data.url.impl;

import com.pigalon.restfb.data.url.UrlProcessing;

public class SoundCloundUrlProcessing implements UrlProcessing{

	public String idExtractionFromUrl(String strUrl) throws Exception {
		
		if(strUrl != null){
			
			int ind = strUrl.indexOf(".com/");
			
			if(ind >0){
				strUrl = strUrl.substring(ind+5);
			}
		}
			
			
		return strUrl;
	}

}
