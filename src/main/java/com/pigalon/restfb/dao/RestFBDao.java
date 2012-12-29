package com.pigalon.restfb.dao;

import java.util.List;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public interface RestFBDao {
	

	public void init(FacebookClient facebookClient);
	/**
	 * Get the feed of FB Group
	 * @param facebookClient : main connection object of RestFB Client
	 * @param groupName : The group name where we'll grab all links
	 * @return Connection<Post> : RestFB object contains all post of a feed
	 */
	public Connection<Post> getGroupFeed(String groupName);
	
	public List<Post> getAllPostFromGroup(String groupName);
	
	public List<Post> getLastPostFromAnIdFromGroup(String groupName, String idLimit);
	

}
