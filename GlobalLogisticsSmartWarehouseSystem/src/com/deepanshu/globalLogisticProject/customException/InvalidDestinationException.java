package com.deepanshu.globalLogisticProject.customException;

public class InvalidDestinationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidDestinationException(String message) {
		super(message);
	}

}
