package com.pigalon.restfb.data;

public enum LinkUrl {
	YOUTUBE("youtu", "Y"),
	VIMEO("vimeo", "V"),
	BANDCAMP("bandcamp", "B"),
	SOUNDCLOUND("soundcloud", "S");
	
	private final String urlPart;
	private final String urlType;
	
	LinkUrl(String urlPart, String urlType){
		this.urlPart = urlPart;
		this.urlType = urlType;
	}
	
	public String getUrlPart(){
		return urlPart;
	}
	
	public String getUrlType(){
		return urlType;
	}
}
