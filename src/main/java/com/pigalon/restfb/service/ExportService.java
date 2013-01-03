package com.pigalon.restfb.service;



public interface ExportService {
	

	/**
	 * main method : export all references of video links on a FB group wall into a csv file 
	 * @param groupName : Name of Groupe from which on we grab all posted link ...
	 * @throws Exception
	 */
	public void exportAllLinks(String groupName) throws Exception;
	

}
