package com.pigalon.restfb.service.impl;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.HandlerService;
import com.restfb.types.Post;

public class HandlerServiceImpl implements HandlerService {

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.HandlerService#constructExportLine((Post post, String urlTypeAndId, StringBuffer buffer)
	 */
	public String constructExportLine(Post post, String urlTypeAndId, StringBuffer buffer)throws Exception{
		
		buffer = new StringBuffer();
		buffer.append(post.getId()).append(" ; ")
		.append(post.getCreatedTime()).append(" ; ")
		.append(urlTypeAndId).append(" ; ")
    	.append(post.getName()).append(" ; ")
    	.append(post.getFrom().getId()).append(" ; ")
    	.append(post.getLikesCount());
		
		return buffer.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.HandlerService#returnUrIdlAndType((Post post)
	 */
	public String returnUrIdlAndType(Post post){
		try {
			
			if(post.getLink().contains(Constants.URL_PART_YOUTUBE)){
				return "Y ; " + new YoutubeUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(Constants.URL_PART_VIMEO)){
				
				return "V ; " + new VimeoUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(Constants.URL_PART_BANDCAMP)){
				return "B ; " + new BandcampUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(Constants.URL_PART_SOUNDCLOUND)){
				return "S ; " + new SoundCloundUrlProcessing().idExtractionFromUrl(post.getLink());
			}
		} catch (Exception e) {
			//TODO log just url without query no erroris throwing, 
			// just return null if processing fail
			// we need to continue
		}
		
		return null;
	}

}
