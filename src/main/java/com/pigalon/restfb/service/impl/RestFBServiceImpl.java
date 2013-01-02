package com.pigalon.restfb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.pigalon.restfb.dao.RestFBDao;
import com.pigalon.restfb.dao.impl.RestFBDaoImpl;
import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.HandlerService;
import com.pigalon.restfb.service.RestFBService;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;


public class RestFBServiceImpl implements RestFBService {
	
	private static RestFBDao restFBDao;
	
	public RestFBServiceImpl(){
		if(restFBDao == null){
			restFBDao = new RestFBDaoImpl();
		}
	}
	
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
	
public List<Post> exportLinkToMem(Connection<Post> groupFeed) throws Exception{
		

		String urlTypeAndId;
		
		List<Post> postList = new ArrayList<Post>();
		
		Function<Post, String> applyFunction = new Function<Post, String>() {
			   public String apply(final Post obj) {
			      return obj.getId();
			   }
			};
			
			Ordering<Post> postOrdering =
					   Ordering.natural().reverse()
					      .onResultOf(applyFunction);
		
		HandlerService handlerService = new HandlerServiceImpl();
				

	    for (List<Post> myFeedConnectionPage : groupFeed){
	    	// avoid FB exceed
	    	Thread.sleep(Constants.FB_QUERY_DELAY);
	        
	    	for (Post post : myFeedConnectionPage){
	    		
       		 	// grab only if there is a link
       			if(post!=null && post.getLink()!=null ){
       				
       				//buffer = null;
       				urlTypeAndId = handlerService.returnUrIdlAndType(post);	
       			 	
		    		if(urlTypeAndId !=null){
		    			postList.add(post);
       			 	}
       				
       			}
       	 	}
	    }
	    return postOrdering.sortedCopy(postList);
		
		
		
	}

}
