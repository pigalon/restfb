package com.pigalon.restfb.service.impl;

import com.pigalon.restfb.service.UrlProcessing;

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
