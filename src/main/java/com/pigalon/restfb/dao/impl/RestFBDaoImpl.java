package com.pigalon.restfb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.pigalon.restfb.dao.RestFBDao;
import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.data.DataHandler;
import com.pigalon.restfb.exception.DAOException;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
/**
 * Handler and access class to the REst FB API 
 * @author Pierrick
 *
 */
public class RestFBDaoImpl implements RestFBDao {
	/**
	 * Main connection object
	 */
	final FacebookClient facebookClient = new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
	


	Function<Post, String> applyFunction = new Function<Post, String>() {
	   public String apply(final Post obj) {
	      return DataHandler.returnPostIdOnly(obj.getId());
	   }
	};
		
	Ordering<Post> postOrdering =
				   Ordering.natural().onResultOf(applyFunction);
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBDao#getGroupFeed(String groupName)
	 */
	public Connection<Post> getGroupFeed(String groupName) {
		return facebookClient.fetchConnection(groupName+"/feed", Post.class);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBDao#getLimitedGroupFeed(String groupName, int number)
	 */
	public Connection<Post> getLimitedGroupFeed(String groupName, int number) {
		 return facebookClient.fetchConnection(groupName+"/feed", Post.class, Parameter.with("limit", number));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBDao#getPostsFromGroup(String groupName, String idLimit)
	 */
	public List<Post> getPostsFromGroup(String groupName, int nbLimit) {
		String urlTypeAndId;
		List<Post> postList = new ArrayList<Post>();
		int cpt=0;
		
		try{
			for (List<Post> myFeedConnectionPage : getGroupFeed(groupName)){
		    	// avoid FB exceed
		    	Thread.sleep(Constants.FB_QUERY_DELAY);
		        
		    	for (Post post : myFeedConnectionPage){
		    		
		    		// reach the limit
		    		if( nbLimit > 0 && cpt>=nbLimit){
		    			return postOrdering.sortedCopy(postList);
		    		}
		    		
	       		 	// grab only if there is a link
	       			if(post!=null && post.getLink()!=null ){

	       				//buffer = null;
	       				urlTypeAndId = DataHandler.returnUrIdlAndType(post);	
	       			 	
			    		if(urlTypeAndId !=null){
		       				cpt++; // here sure about grab link
			    			postList.add(post);
	       			 	}
	       				
	       			}
	       	 	}
		    }
		    return postOrdering.sortedCopy(postList);
		}
		catch(Exception e){
			throw new DAOException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.RestFBDao#getLastPostId(String groupName)
	 */
	public String getLastPostIdFromGroup(String groupName) {
		 Connection<Post> connection =  getLimitedGroupFeed(groupName, 1);
		 if(connection.getData()!=null){
			 return DataHandler.returnPostIdOnly(connection.getData().get(0).getId());
		 }
		 return null;
	}

}
