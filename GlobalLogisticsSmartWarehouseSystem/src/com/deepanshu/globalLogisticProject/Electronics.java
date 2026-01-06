package com.deepanshu.globalLogisticProject;

public class Electronics extends Items{

	private int fragilityLevel;

	public Electronics(String trackingId, double weight, String destination, int fragilityLevel) {
		super(trackingId, weight, destination);
		this.fragilityLevel = fragilityLevel;
	}

	public int getFragilityLevel() {
		return fragilityLevel;
	}
	
		
}
