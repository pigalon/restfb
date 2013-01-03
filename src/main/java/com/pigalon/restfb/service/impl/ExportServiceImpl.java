package com.pigalon.restfb.service.impl;



import java.util.List;

import com.pigalon.restfb.dao.CsvDao;
import com.pigalon.restfb.dao.RestFBDao;
import com.pigalon.restfb.dao.impl.CsvDaoImpl;
import com.pigalon.restfb.dao.impl.RestFBDaoImpl;
import com.pigalon.restfb.service.ExportService;
import com.restfb.types.Post;

public class ExportServiceImpl implements ExportService {
	
	private RestFBDao restFBDao;
	private CsvDao csvDao;
	
	
	public ExportServiceImpl(){
		restFBDao = new RestFBDaoImpl();
		csvDao = new CsvDaoImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pigalon.restfb.service.exportServic#exportLinkToCsv()
	 */
	public void exportAllLinks(String groupName) throws Exception{
		List<Post> posts = restFBDao.getPostsFromGroup(groupName, 10);
		csvDao.writeEntireFile(posts);
	}
	
	




	
	
}
