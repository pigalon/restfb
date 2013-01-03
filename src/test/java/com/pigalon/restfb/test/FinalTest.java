package com.pigalon.restfb.test;

import org.junit.Test;

import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.service.ExportService;
import com.pigalon.restfb.service.impl.ExportServiceImpl;


public class FinalTest {
	/**
	 * Before to use this test check the Constantes.MY_ACCESS_TOKEN :
	 *  1 - you need to connect to your FB account before into your browser
	 *  2 - go to this url https://developers.facebook.com/tools/explorer
	 *  3 - and generate a new access Token
	 *  4 - copy this generated token into com.pigalon.restfb.Constantes.MY_ACCESS_TOKEN
	 *  5 - you can use this test
	 * 
	 */
	@Test
	public void testToGrab(){
		
		ExportService restFb = new ExportServiceImpl();
		
		try {

			// export
			restFb.exportAllLinks(Constants.GROUP_ID);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
