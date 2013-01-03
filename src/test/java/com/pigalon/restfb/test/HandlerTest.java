package com.pigalon.restfb.test;

import org.junit.Assert;
import org.junit.Test;

import com.pigalon.restfb.data.DataHandler;


public class HandlerTest {
	
	String completeId = "151651651_45541654165";
	
	String cuttedId ="45541654165";
	

	@Test
	public void testReturnPostIdOnly(){
		Assert.assertEquals(cuttedId, DataHandler.returnPostIdOnly(completeId));

	}

}
