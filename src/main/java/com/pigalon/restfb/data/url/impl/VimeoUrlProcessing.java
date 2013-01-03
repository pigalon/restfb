package com.pigalon.restfb.data.url.impl;

import com.pigalon.restfb.data.url.UrlProcessing;

public class VimeoUrlProcessing implements UrlProcessing{

	public String idExtractionFromUrl(String strUrl) throws Exception {
		
		if(strUrl != null){
			
			int ind = strUrl.lastIndexOf("/");
			
			if(ind >0){
				strUrl = strUrl.substring(ind+1);
			}
			
		}
			
			
		return strUrl;
	}

}
