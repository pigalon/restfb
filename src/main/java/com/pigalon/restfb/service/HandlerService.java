package com.pigalon.restfb.service;

import com.restfb.types.Post;

public interface HandlerService {
	
	/**
	 * construction of the data line to storage into csv file
	 * @param post
	 * @param urlTypeAndId
	 * @param buffer : StringBuffer to concat 
	 * @return String : to write in a file
	 * @throws Exception
	 */
	String constructExportLine(Post post, String urlTypeAndId, StringBuffer buffer)throws Exception;
	
	/**
     * return initial type of the url concat with id processed from url
     *
     * Ex : Y ; 12r5r651r => Y for Youtube and the id number of the movie
     *      Juste add before http://www.youtube.com?v= + this id number
     *      
     * @param post : Object of the RestFB API
     * @return String : type + id / or null if no query or processing fail
     */
	String returnUrIdlAndType(Post post);
}
