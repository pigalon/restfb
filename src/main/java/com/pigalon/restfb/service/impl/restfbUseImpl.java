package com.pigalon.restfb.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.UrlProcessing;
import com.pigalon.restfb.service.restfbUse;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

public class restfbUseImpl implements restfbUse {

	private Connection<Post> getGroupFeed(FacebookClient facebookClient, String groupName) {
		// test groupName
		return facebookClient.fetchConnection(groupName+"/feed", Post.class);
	}
	
		
	
    private String constructExportLine(Post post, String linkType)throws Exception{
		StringBuffer buffer = null;
		UrlProcessing urlProcessingTool = null;
		String link="";
		
		
		
		if(urlProcessingTool !=null){
			link = urlProcessingTool.idExtractionFromUrl(post.getLink());
			buffer = new StringBuffer();
			buffer.append(post.getId()).append(" ; ")
			.append(post.getCreatedTime()).append(" ; ")
			.append(link).append(" ; ")
			.append(linkType).append(" ; ") 
        	.append(post.getName()).append(" ; ")
        	.append(post.getFrom().getId());
			return buffer.toString();
		}
		return null;
	}



	private String containsUrlType(Post post, String linkType) throws Exception {
		if(post.getLink().contains(Constants.YOUTUBE_URL_PART)){
			linkType = Constants.YOUTUBE_URL_PART;
			return new YoutubeUrlProcessing().idExtractionFromUrl(post.getLink());
    	}
		else if(post.getLink().contains(Constants.VIMEO_URL_PART)){
			linkType = Constants.VIMEO_URL_PART;
			return new VimeoUrlProcessing().idExtractionFromUrl(post.getLink());
		}
		else if(post.getLink().contains(Constants.BANDCAMP_URL_PART)){
			linkType = Constants.BANDCAMP_URL_PART;
			return null;
		}
		return null;
	}
	
	
	

	public User getMe() {
		// TODO Auto-generated method stub
		return null;
	}

	public void exportLinkToCsv(String groupName) throws Exception{
		FacebookClient facebookClient = new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
		Connection<Post> groupFeed = getGroupFeed(facebookClient, groupName);
		
		
		try {
			BufferedWriter outputFile = new BufferedWriter(new FileWriter(Constants.EXPORT_FILE));
		
		
    
		    for (List<Post> myFeedConnectionPage : groupFeed){
		        
		    	for (Post post : myFeedConnectionPage){
		    		
	       		 	// grab only if there is a link
	       			if(post!=null && post.getLink()!=null ){
	       				String linkType="";
			    		linkType = containsUrlType(post, linkType);	
	       			 if(linkType !=null){	
	       			 outputFile.write(constructExportLine(post, linkType));
					 outputFile.newLine();
	       			 }
	       				
	       			}
	       	 	}
		    }
		} catch (IOException e) {
			throw new Exception("export to file problem");
		}

	}

}
