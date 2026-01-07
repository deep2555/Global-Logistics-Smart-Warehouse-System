package com.deepanshu.globalLogisticProject;

/*this type of the abstract class sharing the common behavior among classes
 * 
*/
public abstract class Items {

	//common variable
	private String trackingId;
	private double weight;
	private String destination;
	
	public Items(String trackingId, double weight, String destination) {
		super();
		this.trackingId = trackingId;
		this.weight = weight;
		this.destination = destination;
		
	}

	public String getTrackingId() {
		return trackingId;
	}

	public double getWeight() {
		return weight;
	}

	public String getDestination() {
		return destination;
	}
	
	
	
}
