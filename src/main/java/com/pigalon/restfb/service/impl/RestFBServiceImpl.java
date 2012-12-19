package com.pigalon.restfb.service.impl;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.RestFBService;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public class RestFBServiceImpl implements RestFBService {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBService#getAuthenticatedClient()
	 */
	public FacebookClient getAuthenticatedClient() {
		return new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBService#getGroupFeed(FacebookClient facebookClient,
			String groupName)
	 */
	public Connection<Post> getGroupFeed(FacebookClient facebookClient,
			String groupName) {
		return facebookClient.fetchConnection(groupName+"/feed", Post.class);
	}

}
