package com.pigalon.restfb.test;

import org.junit.Test;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.restfbUse;
import com.pigalon.restfb.service.impl.restfbUseImpl;

public class FinalTest {
	
	@Test
	public void testToGrab(){
		restfbUse apiTool = new restfbUseImpl();
		try {
			apiTool.exportLinkToCsv(Constants.ID_INDIE_GROUP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
