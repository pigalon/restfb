package com.pigalon.restfb.service;

import com.restfb.Connection;
import com.restfb.types.Post;


public interface exportService {
	

	/**
	 * main method : export all references of video links on a FB group wall into a csv file 
	 * @param feed : Connection<Post> for m restfb : all Post about Group, Page, User ...
	 * @throws Exception
	 */
	public void exportLinkToCsv(Connection<Post> feed) throws Exception;
	

}
