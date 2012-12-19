package com.pigalon.restfb.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.HandlerService;
import com.pigalon.restfb.service.exportService;
import com.restfb.Connection;
import com.restfb.types.Post;

public class exportServiceImpl implements exportService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.exportServic#exportLinkToCsv()
	 */
	public void exportLinkToCsv(Connection<Post> groupFeed) throws Exception{
		
		BufferedWriter outputFile= null;
		StringBuffer buffer = null;
		String urlTypeAndId;
		
		HandlerService handlerService = new HandlerServiceImpl();
				

		try {
			outputFile = new BufferedWriter(new FileWriter(Constants.EXPORT_FILE));
    
		    for (List<Post> myFeedConnectionPage : groupFeed){
		    	// avoid FB exceed
		    	Thread.sleep(Constants.FB_QUERY_DELAY);
		        
		    	for (Post post : myFeedConnectionPage){
		    		
	       		 	// grab only if there is a link
	       			if(post!=null && post.getLink()!=null ){
	       				buffer = null;
			    		urlTypeAndId = handlerService.returnUrIdlAndType(post);	
	       			 	
			    		if(urlTypeAndId !=null){
			    			buffer = new StringBuffer();
			    			
	       			 		outputFile.write(handlerService.constructExportLine(post, urlTypeAndId,buffer));
	       			 		outputFile.newLine();
	       			 	}
	       				
	       			}
	       	 	}
		    }
		} catch (IOException e) {
			throw new Exception("export to file problem");
		}
		finally{
			if(outputFile!=null){
				outputFile.flush();
		        outputFile.close();
			}
		}

	}
	
	




	
	
}
