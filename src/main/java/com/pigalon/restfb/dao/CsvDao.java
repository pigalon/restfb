package com.pigalon.restfb.dao;

public interface CsvDao {
	
	public boolean resultFileIsalreadyExists();
	
	/* determine the limit id to search until it */
	public String lastResultatId();
	
	public void writeEntireFile(StringBuffer buffer);
	
	public void addInFile(StringBuffer buffer);
	

}
