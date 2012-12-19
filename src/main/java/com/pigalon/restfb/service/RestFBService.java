package com.pigalon.restfb.service;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public interface RestFBService {
	/**
	 * get the Authenticated client
	 * 
	 * use this url before : https://developers.facebook.com/tools/explorer
	 *  1 - generate a new access Token
	 *  2 - copy this token to Constantes.MY_ACCESS_TOKEN
	 *  3 - you can use this method
	 *  //TODO a new method with WebRequestor : auto get token
	 *   
	 * 
	 * @return FacebookClient restfb Object : a authenticated client to use to query FB data
	 */
	public FacebookClient getAuthenticatedClient();
	
	/**
	 * Get the feed of FB Group
	 * @param facebookClient : main connection object of RestFB Client
	 * @param groupName : The group name where we'll grab all links
	 * @return Connection<Post> : RestFB object contains all post of a feed
	 */
	public Connection<Post> getGroupFeed(FacebookClient facebookClient, String groupName);

}
