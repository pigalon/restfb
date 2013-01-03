package com.pigalon.restfb.service.impl;

import com.pigalon.restfb.data.LinkUrl;
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
		buffer.append(returnPostIdOnly(post.getId())).append(" ; ")
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
	 * @see com.pigalon.restfb.service.HandlerService#returnUrIdlAndType(Post post)
	 */
	public String returnUrIdlAndType(Post post){
		try {
			
			if(post.getLink().contains(LinkUrl.YOUTUBE.getUrlPart())){
				return LinkUrl.YOUTUBE.getUrlType() + " ; " + new YoutubeUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(LinkUrl.VIMEO.getUrlPart())){
				return LinkUrl.VIMEO.getUrlType() + " ; " + new VimeoUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(LinkUrl.BANDCAMP.getUrlPart())){
				return LinkUrl.BANDCAMP.getUrlType() + " ; " + new BandcampUrlProcessing().idExtractionFromUrl(post.getLink());
			}
			else if(post.getLink().contains(LinkUrl.SOUNDCLOUND.getUrlPart())){
				return LinkUrl.SOUNDCLOUND.getUrlType() + " ; " + new SoundCloundUrlProcessing().idExtractionFromUrl(post.getLink());
			}
		} catch (Exception e) {
			//TODO log just url without query no erroris throwing, 
			// just return null if processing fail
			// we need to continue
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.HandlerService#returnPostIdOnly(String completeId)
	 */
	public String returnPostIdOnly(String completeId) {
		if(completeId!=null){
			String [] strTab = completeId.split("_");
			if(strTab !=null && strTab.length>1){
				return strTab[1];
			}
		}
		return null;
	}

}
