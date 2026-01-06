package com.deepanshu.globalLogisticProject;

public class Perishables extends Items{

	private String expiryDate;

	public Perishables(String trackingId, double weight, String destination, String expiryDate) {
		super(trackingId, weight, destination);
		this.expiryDate = expiryDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}
	
	
	// concrete method to calculate if they are "Expired" based on a provided current date.
	public boolean isExpiry(String providedDate) {
		return expiryDate.compareTo(providedDate)< 0;
	}
	
	
	/*
	 * public static void main(String[] args) { Perishables pp = new
	 * Perishables("1", 12.32, "Delhi", "2014");
	 * System.out.println(pp.calculateExpiry("2013")); }
	 */
}
