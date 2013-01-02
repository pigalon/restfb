package com.pigalon.restfb.exception;

public class DAOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(Exception e){
		super(e);
	}

}
