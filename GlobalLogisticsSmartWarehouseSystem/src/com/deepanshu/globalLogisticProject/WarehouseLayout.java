package com.deepanshu.globalLogisticProject;

import com.deepanshu.globalLogisticProject.customException.InvalidDestinationException;
import com.deepanshu.globalLogisticProject.customException.StorageFullException;

/*
The warehouse is represented as a 10x10 Grid (a 2D Array of your base item type).
*/
public class WarehouseLayout {

	private Items[][] grid = new Items[10][10];

	// method that can hold or put items in that grid

	public void putItems(Items item, int column, int row, String destination) {
		/*
		 * several condition to check 1) check for the destination 2) check if the input
		 * is in the range from 10 by 10 3) check if the grid is already taken or not
		 * 
		 */
		if (destination == null || destination.isEmpty() || destination.trim().length() <= 3) {
			throw new InvalidDestinationException("Destination cannot be null empty or less than 3 character");
		}

		if ((row <= 0 || row >= 10) || (column <= 0 || column >= 10)) {
			throw new InvalidDestinationException("invalid input for rows and column");
		}

		if (grid[row][column] != null) {
			throw new StorageFullException("the grid position already has items ::");
		}

		grid[row][column] = item;
	}

	// method to display the warehouse map

	public void displayWarehouseMap() {

		// loop through the grid and symbolic the items as per the location

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				if (grid[i][j] == null) {
					System.out.println(".");

				} else if (grid[i][j] instanceof Electronics) {
					System.out.println("E");

				} else if (grid[i][j] instanceof Perishables) {
					System.out.println("P");

				} else if (grid[i][j] instanceof DangerousGoods) {
					System.out.println("D");

				}

				System.out.println();
			}
		}
	}
}
