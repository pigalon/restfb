package com.pigalon.restfb.dao;

import java.io.IOException;
import java.util.List;

import com.restfb.types.Post;

public interface CsvDao {
	
	public boolean resultFileIsAlreadyExists();
	
	/* determine the limit id to search until it */
	public String getLastId() throws IOException;
	
	public void saveLastId(String lastId) throws IOException;
	
	public void writeEntireFile(List<Post> post) throws IOException, Exception;
	
	public void appendFile(List<Post> post);
	

}
