package com.deepanshu.globalLogisticProject.InterviewTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deepanshu.globalLogisticProject.Items;

// Special class for the interviewer task
public class DestinationClusture {

	public List<Items> findHeavyClusture(String targetDestination, Items[][] grid) {

		/*
		 * It should:Find all items heading to the same destination.
		 */
		List<Items> destinationList = new ArrayList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				Items item = grid[i][j];

				if (item != null && item.getDestination().equalsIgnoreCase(targetDestination)) {
					destinationList.add(item);
				}
			}
		}

		/*
		 * calculate the total weight of those item
		 */

		return destinationList;
	}

	public double findTotalWeight(List<Items> destinationList) {
		double weight = 0;
		for (Items listItems : destinationList) {
			weight += listItems.getWeight();

		}
		System.out.println("the total weight is :" + weight);

		return weight;
	}

	// dsa type question
	public void getShippingManifest(Items[][] grid) {
		/*
		 * It should take all items currently in the warehouse, put them into a 1D
		 * Array, and sort them primarily by weight (descending).
		 */
		Items[] convertedArray = new Items[grid.length * grid.length];
		int index = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null) {
					convertedArray[index++] = grid[i][j];
				}

			}
		}
		Items[] finalArray = new Items[index];
		System.arraycopy(convertedArray, 0, finalArray, 0, index);

		double weight;
		for (Items fc : finalArray) {
			System.out.print(fc.getDestination() + " " + fc.getTrackingId() + " " + fc.getWeight());
			weight = fc.getWeight();
			System.out.println();
			
			Arrays.sort(finalArray, (a, b) -> {
			    // Compare weight descending
			    int weightCompare = Double.compare(((Items) b).getWeight(), ((Items) a).getWeight());
			    if (weightCompare != 0) {
			        return weightCompare;
			    } else {
			        return a.getTrackingId().compareTo(b.getTrackingId());
			    }
			 });
			 System.out.println();
			 System.out.print(fc.getDestination() + " " + fc.getTrackingId() + " " + fc.getWeight());
		}
		
		// sort them by weight
		
		
	}

}
