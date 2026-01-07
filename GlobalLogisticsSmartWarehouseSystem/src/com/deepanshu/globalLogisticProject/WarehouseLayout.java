package com.deepanshu.globalLogisticProject;

import com.deepanshu.globalLogisticProject.customException.InvalidDestinationException;
import com.deepanshu.globalLogisticProject.customException.SafetyViolationException;
import com.deepanshu.globalLogisticProject.customException.StorageFullException;
import com.deepanshu.globalLogisticProject.transactionLogs.TransactionalLogs;

/*
The warehouse is represented as a 10x10 Grid (a 2D Array of your base item type).
*/
public class WarehouseLayout {

	private Items[][] grid = new Items[10][10];
	private char[][] gridViewRetrieve = new char[10][10];
	private TransactionalLogs tcLogs = new TransactionalLogs();

	// test

	public static void main(String[] args) {
		WarehouseLayout wc = new WarehouseLayout();
		Electronics ec = new Electronics("1", 123, "delhi", 3);
		Perishables pc = new Perishables("2", 1234, "ludhiana", "2012");
		DangerousGoods dc = new DangerousGoods("3", 12345, "chandigarh", 123);
		
		TransactionalLogs tc = new TransactionalLogs();
		

//		wc.putItems(ec, 1, 0, "delhi");
//		wc.putItems(pc, 1, 1, "ludhiana");
//		wc.putItems(dc, 3, 1, "chandigarh");

//		wc.displayWarehouseMap();
		try {
			tc.loadLastSession(wc.gridViewRetrieve);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(tc.getLogs()+ " ");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
					System.out.print(wc.gridViewRetrieve[i][j]+ " ");	
				
			}
			System.out.println();
	
		}
		
	}

	// method that can hold or put items in that grid

	public void putItems(Items item, int row, int column, String destination) {
		/*
		 * several condition to check 1) check for the destination 2) check if the input
		 * is in the range from 10 by 10 3) check if the grid is already taken or not
		 * 
		 */
		if (destination == null || destination.isEmpty() || destination.trim().length() <= 3) {
			throw new InvalidDestinationException("Destination cannot be null empty or less than 3 character");
		}

		if ((row < 0 || row > 10) || (column < 0 || column > 10)) {
			throw new InvalidDestinationException("invalid input for rows and column");
		}

		if (grid[row][column] != null) {
			throw new StorageFullException("the grid position already has items ::");
		}

		if (ifSafetyViolation(row, column, item)) {
			throw new SafetyViolationException("dangerous good cannot be placed near Perishables good");

		}

		grid[row][column] = item;
		// here to add the logs
		tcLogs.displayLogs("Item [" + item.getTrackingId() + "] placed at [" + row + "," + column + "]");
		tcLogs.saveSession(grid);
	}

	// method to check the safety violation
	private boolean ifSafetyViolation(int row, int column, Items item) {

		if (!(item instanceof DangerousGoods)) {
//			System.out.println("this is not the item of dangerous good");
			return false;
		}

		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		// loop through each direction
		for (int[] pointers : directions) {
			int rc = row + pointers[0];
			int col = column + pointers[1];

			// we will check for the condition for the index
			if ((rc >= 0 && rc < grid.length) && (col >= 0 && col < grid.length)) {

				if (grid[rc][col] instanceof Perishables) {
					return true;
				}
			}
		}

		return false;
	}

	// method to display the warehouse map

	public void displayWarehouseMap() {

		// loop through the grid and symbolic the items as per the location

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				if (grid[i][j] == null) {
					System.out.print(". ");

				} else if (grid[i][j] instanceof Electronics) {
					System.out.print("E ");

				} else if (grid[i][j] instanceof Perishables) {
					System.out.print("P ");

				} else if (grid[i][j] instanceof DangerousGoods) {
					System.out.print("D ");

				}

			}
			System.out.println();
		}
	}
}
