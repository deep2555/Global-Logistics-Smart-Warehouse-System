package com.deepanshu.globalLogisticProject.customException;

public class SafetyViolationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SafetyViolationException(String message) {
		super(message);
	}
}
