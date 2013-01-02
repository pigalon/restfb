package com.pigalon.restfb.test;

import org.junit.Before;
import org.junit.Test;

import com.pigalon.restfb.service.HandlerService;
import com.pigalon.restfb.service.impl.HandlerServiceImpl;

public class HandlerTest {
	
	HandlerService handler;
	
	@Before
	public void init(){
		handler = new HandlerServiceImpl();
	}
	
	@Test
	public void testReturnPostIdOnly(){
		String completeId = "151651651_45541654165";
		System.out.println(handler.returnPostIdOnly(completeId));

	}

}
