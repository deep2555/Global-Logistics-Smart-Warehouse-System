package com.deepanshu.globalLogisticProject.transactionLogs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.deepanshu.globalLogisticProject.DangerousGoods;
import com.deepanshu.globalLogisticProject.Electronics;
import com.deepanshu.globalLogisticProject.Items;
import com.deepanshu.globalLogisticProject.Perishables;

public class TransactionalLogs {

	// array list to add all the logs
	private List<String> logs = new ArrayList<>();
	
	
// getter to get the logs
	public List<String> getLogs() {
		return logs;
	}

	// method to display the logs
	public void displayLogs(String message) {
		System.out.println(message);
		logs.add(message);
	}

	// method for the save session
	public void saveSession(Items[][] grid) {

		// first have to create the destination to save the file
		String fileDestination = "D:\\Mini Projects Java\\warehouse_log.txt";
		try (FileWriter fileWriter = new FileWriter(fileDestination)) {

			// entire content of the array list
			fileWriter.write("=======Warehouse Logs======");
			fileWriter.write("\n");
			for (String writeLogs : logs) {
				fileWriter.write(writeLogs);
				fileWriter.write("\n");

			}

			fileWriter.write("=======Warehouse grids logs======");
			fileWriter.write("\n");
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {

					if (grid[i][j] == null) {
						fileWriter.write(". ");
					} else if (grid[i][j] instanceof Electronics) {
						fileWriter.write("E ");

					} else if (grid[i][j] instanceof Perishables) {
						fileWriter.write("P ");

					} else if (grid[i][j] instanceof DangerousGoods) {
						fileWriter.write("D ");
					}

				}
				fileWriter.write("\n");
			}

		} catch (IOException e) {
			System.out.println("not able to write the file ");
			e.printStackTrace();
		}

	}

	// read the file and reconstruct it

	public void loadLastSession(char[][] grid) {
		String fileLocation = "D:\\Mini Projects Java\\warehouse_log.txt";

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {

			String line = null;
			boolean readLogs = false;
			boolean readGrid = false;
			int gridCount = 0;

			while ((line = bufferedReader.readLine()) != null) {

				// condition
				if (line.startsWith("=======Warehouse Logs======")) {
					readLogs = true;
					readGrid = false;
					continue;
				}

				if (line.startsWith("=======Warehouse grids logs======")) {
					readLogs = false;
					readGrid = true;
					continue;
				}

				if (readLogs) {
					System.out.println("lines are achieving ");
					logs.add(line);
				} else if (readGrid) {
					String[] splitCol = line.split(" ");
					for (int col = 0; col < splitCol.length; col++) {
						grid[gridCount][col] = splitCol[col].charAt(0);

					}
					gridCount++;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
