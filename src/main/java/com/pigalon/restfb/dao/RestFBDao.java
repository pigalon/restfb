package com.pigalon.restfb.dao;

import java.util.List;

import com.restfb.Connection;
//import com.restfb.FacebookClient;
import com.restfb.types.Post;

public interface RestFBDao {
	

	/**
	 * Get the feed of FB Group
	 * @param facebookClient : main connection object of RestFB Client
	 * @param groupName : The group name where we'll grab all links
	 * @return Connection<Post> : RestFB object contains all post of a feed
	 */
	Connection<Post> getGroupFeed(String groupName);
	/**
	 * get a limited feed of FB Group
	 * @param groupName
	 * @return Connection<Post> : RestFB object contains all post of a feed
	 */
	Connection<Post> getLimitedGroupFeed(String groupName, int number);
	
	/**
	 * get all Posts from the beginning or from the id limit
	 * @param groupName
	 * @param idLimit
	 * @return List<Post>
	 */
	List<Post> getPostsFromGroup(String groupName, int nbLimit);
	
	/**
	 * return the last id from the group feed
	 * @param groupName
	 * @return String : id
	 */
	String getLastPostIdFromGroup(String groupName);
	

}
