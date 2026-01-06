package com.deepanshu.globalLogisticProject;

public class DangerousGoods extends Items {

	private int hazarCode;

	public DangerousGoods(String trackingId, double weight, String destination, int hazarCode) {
		super(trackingId, weight, destination);
		this.hazarCode = hazarCode;
	}

	public int getHazarCode() {
		return hazarCode;
	}
	
	// concrete method for specific safety protocol message that must be displayed whenever they are moved.

	public void move() {
		System.out.println("Please carefull while moving this is the safety hazar ::"+ hazarCode);
	}
}
