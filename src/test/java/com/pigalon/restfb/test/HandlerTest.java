package com.pigalon.restfb.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pigalon.restfb.service.HandlerService;
import com.pigalon.restfb.service.impl.HandlerServiceImpl;

public class HandlerTest {
	
	HandlerService handler;

	String completeId = "151651651_45541654165";
	
	String cuttedId ="45541654165";
	
	@Before
	public void init(){
		handler = new HandlerServiceImpl();
	}
	
	@Test
	public void testReturnPostIdOnly(){
		Assert.assertEquals(cuttedId, handler.returnPostIdOnly(completeId));

	}

}
