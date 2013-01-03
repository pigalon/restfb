package com.pigalon.restfb.data;

import com.pigalon.restfb.data.url.impl.BandcampUrlProcessing;
import com.pigalon.restfb.data.url.impl.SoundCloundUrlProcessing;
import com.pigalon.restfb.data.url.impl.VimeoUrlProcessing;
import com.pigalon.restfb.data.url.impl.YoutubeUrlProcessing;
import com.restfb.types.Post;

public final class DataHandler {

	
	/**
	 * construction of the data line to storage into csv file
	 * @param post
	 * @param urlTypeAndId
	 * @param buffer : StringBuffer to concat 
	 * @return String : to write in a file
	 * @throws Exception
	 */
	public static String constructExportLine(Post post, String urlTypeAndId, StringBuffer buffer)throws Exception{
		
		buffer = new StringBuffer();
		buffer.append(returnPostIdOnly(post.getId())).append(" ; ")
		.append(post.getCreatedTime()).append(" ; ")
		.append(urlTypeAndId).append(" ; ")
    	.append(post.getName()).append(" ; ")
    	.append(post.getFrom().getId()).append(" ; ")
    	.append(post.getLikesCount());
		
		return buffer.toString();
	}
	
	/**
     * return initial type of the url concat with id processed from url
     *
     * Ex : Y ; 12r5r651r => Y for Youtube and the id number of the movie
     *      Juste add before http://www.youtube.com?v= + this id number
     *      
     * @param post : Object of the RestFB API
     * @return String : type + id / or null if no query or processing fail
     */
	public static String returnUrIdlAndType(Post post){
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

	/**
	 * cut the complete id and return only the post id : easy to sort
	 * @param completeId
	 * @return String : cuttedId
	 */
	public static String returnPostIdOnly(String completeId) {
		if(completeId!=null){
			String [] strTab = completeId.split("_");
			if(strTab !=null && strTab.length>1){
				return strTab[1];
			}
		}
		return null;
	}

}
