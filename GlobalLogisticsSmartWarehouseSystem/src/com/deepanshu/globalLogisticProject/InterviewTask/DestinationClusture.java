package com.deepanshu.globalLogisticProject.InterviewTask;

import java.util.ArrayList;
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
		for(Items listItems : destinationList) {
			weight  += listItems.getWeight();
			
		}
		System.out.println("the total weight is :" + weight);
		
		return weight;
	}
}
