package com.pigalon.restfb.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pigalon.restfb.dao.CsvDao;
import com.pigalon.restfb.data.Constants;
import com.pigalon.restfb.data.DataHandler;
import com.restfb.types.Post;

public class CsvDaoImpl implements CsvDao {

	File exportFile = new File(Constants.EXPORT_FILE);
	File saveFile = new File(Constants.SAVE_FILE);
	
	
	public boolean resultFileIsAlreadyExists() {
		return exportFile.exists();
	}
	
	public String getLastId() throws IOException{
		FileReader reader = null;
		BufferedReader in = null;
		String lastId="";
		try{
			if(saveFile.exists()){
				reader = new FileReader(saveFile);
				in = new BufferedReader(reader);
				lastId = in.readLine();
				
			}
		}
		catch(Exception e){
		}
		finally{
			if (in !=null){
				in.close();
				reader.close();
			}
		}
		return lastId;
		
	}
	
	public void saveLastId(String lastId) throws IOException {
		FileWriter writer = null;
		BufferedWriter out = null;
		
		try{
			if(saveFile.exists()){
				out = new BufferedWriter(writer);
				out.write(lastId);
			}
		}
		catch(IOException e){
			throw e;
		}
		finally{
			out.flush();
			out.close();
		}
		
	}

	public void writeEntireFile(List<Post> posts) throws IOException, Exception {
		BufferedWriter outputFile= null;
		StringBuffer buffer = null;
		String urlTypeAndId;
		
		try {
			outputFile = new BufferedWriter(new FileWriter(exportFile));
    
	    	for (Post post : posts){
	    		
       		 	// grab only if there is a link
       			if(post!=null && post.getLink()!=null ){
       				buffer = null;
		    		urlTypeAndId = DataHandler.returnUrIdlAndType(post);	
       			 	
		    		if(urlTypeAndId !=null){
		    			buffer = new StringBuffer();
       			 		outputFile.write(DataHandler.constructExportLine(post, urlTypeAndId,buffer));
       			 		outputFile.newLine();
       			 	}
       				
       			}
       	 	}
		    
		} catch (IOException e) {
			throw e;
		}
		finally{
			if(outputFile!=null){
				outputFile.flush();
		        outputFile.close();
			}
		}
	}

	public void appendFile(List<Post> post) {
		// TODO Auto-generated method stub

	}

	

}
