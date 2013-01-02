package com.pigalon.restfb.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pigalon.restfb.dao.RestFBDao;
import com.pigalon.restfb.dao.impl.RestFBDaoImpl;
import com.pigalon.restfb.data.Constants;
import com.restfb.types.Post;

public class RestFBDaoTest {
	
	RestFBDao restFBDao;
	
	@Before
	public void init(){
		restFBDao = new RestFBDaoImpl();
	}
	
	@Test
	public void testGetLastPostIdFromGroup(){
		 Assert.assertNotNull(restFBDao.getLastPostIdFromGroup(Constants.GROUP_ID));
	}
	
	@Test
	public void testGetPostListFromGroup(){
		int testSize = 10;
		List<Post> posts = restFBDao.getPostsFromGroup(Constants.GROUP_ID, testSize);
		for(Post post : posts){
			System.out.println(post.getId());
		}
		Assert.assertEquals(posts.size(), testSize);
	}

}
