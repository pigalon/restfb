package com.pigalon.restfb.service;

import com.restfb.types.User;

public interface restfbUse {
	
	public User getMe();
	
	public void exportLinkToCsv(String groupName) throws Exception;
	

}
