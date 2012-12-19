package com.pigalon.restfb.data;

/**
 * 
 * @author Pierrick
 *
 * Ugly, but I use first this interface to set all vars
 * the one most importante are : MY_ACCESS_TOKEN and ID_INDIE_GROUP
 *
 */
public interface Constants {
	
	
	/*
	 * FIRST STEP : PUT YOUR ACCESS TOKEN HERE !!!
	 */
	static String MY_ACCESS_TOKEN = "";
	
	/*
	 * PUT THE ID OF THE GROUP HERE, ex for indie group = 125514040798822
	 */
	static String GROUP_ID = "125514040798822";
	
	/*
	 * PUT THE NAME OF THE EXPORT FILE
	 */
	static String EXPORT_FILE = "test.csv";
	
	
	//*************** DON'T TOUCH THE FOLLOWING CONSTANTS ********************
	// Unless you know that what you are doing
	
	/*
	 * To avoid a FB query overhead (limit = 600 queries / 600 sec)
	 */
	static int FB_QUERY_DELAY =1500;
	
	/*
	 * -------- URL part -----------
	 */
	static String URL_PART_YOUTUBE = "youtu"; // because youtube.com ou youtu.be ...
	static String URL_PART_VIMEO = "vimeo";
	static String URL_PART_BANDCAMP = "bandcamp";
	static String URL_PART_SOUNDCLOUND = "soundcloud";
	
	/*
	 * ------- URL type characters ------
	 */
	static String URL_TYPE_YOUTUBE_TYPE = "Y";
	static String URL_TYPE_VIMEO_URL_TYPE = "V";
	static String URL_TYPE_BANDCAMP_URL_TYPE = "B";
	static String URL_TYPE_SOUNDCOULD = "S";
	
}
