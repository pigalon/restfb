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
	 * FIRST STEP : GIVE YOUR ACCESS TOKEN HERE !!!
	 */
	static String MY_ACCESS_TOKEN = "";
	
	/*
	 * GIVE THE ID OF THE GROUP HERE, ex for indie group = 125514040798822
	 */
	static String GROUP_ID = "125514040798822";
	
	/*
	 * GIVE THE NAME OF THE EXPORT FILE
	 */
	static String EXPORT_FILE = "export.csv";
	
	/*
	 * GIVE THE NAME OF THE EXPORT FILE SEPARATOR
	 */
	static String EXPORT_FILE_SEPARATOR = ";";
	
	/*
	 * GIVE THE NAME OF THE SAVE FILE
	 */
	static String SAVE_FILE = "save.csv";
	
	
	//*************** DON'T TOUCH THE FOLLOWING CONSTANTS ********************
	// Unless you know that what you are doing
	
	/*
	 * To avoid a FB query overhead (limit = 600 queries / 600 sec)
	 */
	static int FB_QUERY_DELAY =1500;
	
}
