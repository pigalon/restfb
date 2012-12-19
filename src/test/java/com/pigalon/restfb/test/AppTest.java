package com.pigalon.restfb.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

import com.pigalon.restfb.data.Constants;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
        try{
        	// put in the constant the Access token grabbed 
        	// from this link : https://developers.facebook.com/tools/explorer
	        FacebookClient facebookClient = new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
	        
	        // get you
	        User user = facebookClient.fetchObject("me", User.class);
	        
	        // get the group target
	        // /125514040798822?fields=feed
	        Group indieGroup = facebookClient.fetchObject("125514040798822", Group.class);
	        
	        
	        System.out.println("first name : " + user.getFirstName() + " - " + indieGroup.getOwner());
	        
	        Connection<Post> indieGroupFeed = facebookClient.fetchConnection("125514040798822/feed", Post.class);
	        System.out.println("First item in my feed: " + indieGroupFeed.getData().size());
	        
	        BufferedWriter outputFile = new BufferedWriter(new FileWriter("test.csv"));
	        
	        StringBuffer buffer = null;
	        
	        for (List<Post> myFeedConnectionPage : indieGroupFeed){
	        
	        	 for (Post post : myFeedConnectionPage){
	        		 
	        		 	// grab only if there is a link
	        			if(post!=null && post.getLink()!=null){ 
	        				
	        				// if link type is youtube or another ... add conditions 
	        				if(post.getLink().contains("youtube")){
	        				
	        					// need to pocess url to simplify data the output Stream
	        					// call to processingUrl services
	        					
		        				buffer = new StringBuffer();
		        				buffer.append(post.getId()).append(" ; ")
		        				.append(post.getCreatedTime()).append(" ; ")
		        				.append(post.getLink()).append(" ; ") // to process
		        	        	.append(post.getName()).append(" ; ")
		        	        	.append(post.getFrom().getId());
		        				
		        				//System.out.println(buffer);
		        				 outputFile.write(buffer.toString());
		        				 outputFile.newLine();
	        	        	}
	        			}
	        	  }
	        	 System.out.println("Post time: " + myFeedConnectionPage.get(0).getCreatedTime());
	        }
	        outputFile.flush();
	        outputFile.close();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        
        
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
