package com.pigalon.restfb.test;

import org.junit.Test;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

import com.pigalon.restfb.data.Constants;


/**
 * Unit test for simple App.
 */
public class RapidTest{

	/**
	 * Rapide API use
	 */
	@Test
    public void rapidTest()
    {
        
        try{
        	// put in the constant the Access token grabbed 
        	// from this link : https://developers.facebook.com/tools/explorer
	        FacebookClient facebookClient = new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
	        
	        // ex : get you
	        User user = facebookClient.fetchObject("me", User.class);
	        
	        // get the group target
	        // /125514040798822?fields=feed
	        Group indieGroup = facebookClient.fetchObject("125514040798822", Group.class);
	        
	        
	        System.out.println("first name : " + user.getFirstName() + " - " + indieGroup.getOwner());
	        
	        Connection<Post> indieGroupFeed = facebookClient.fetchConnection("125514040798822/feed", Post.class);
	        System.out.println("First item in my feed: " + indieGroupFeed.getData().get(0));
	       
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }


}
