package friedman.maxSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import friedman.tictactoe.Location;

public class MaxSum {
	
	private Integer[][] matrix;

	public MaxSum() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		Scanner read = new Scanner(new File("maxsum.txt"));
		int arraySize = read.nextInt();
		matrix = new Integer[arraySize][arraySize];
		for (int i = 0; i < arraySize && read.hasNextLine(); i++) {
			for (int k = 0; k < arraySize; k++) {
				matrix[i][k] = read.nextInt();

			}
		}
		/*
		 * Strategy: Find largest nums and branch out from there Find max value
		 * column, subset, from there
		 */

	}

	public Integer findMaxSum() {
		// for 1D rectangles
		Long start = System.currentTimeMillis();
		int placeAlongDiagonal = 0;
		int maxSum = 0;
		int largerOf2Sums = 0;
		//placeAlongDiagonal ensures that the width of a rectangle be less than 100 rectangles
		while (placeAlongDiagonal < 99) {
			//moves the starting index, the position for which we begin to check the rectangle
			for (int i = 0; i < matrix.length - 1; i++) {

				//In this loop, the rectangle is extended rightwards and then downwards
				for (int width = i + 1; width < matrix.length - placeAlongDiagonal; width++) {
 
					for (int length = width; length < matrix.length; length++) {
						
						int extendRight =findSubMatrixSum(i,placeAlongDiagonal,
								length, width);
						int extendDownwards = findSubMatrixSum(
								placeAlongDiagonal,i, width, length);;
						largerOf2Sums = extendRight >= extendDownwards? extendRight
								: extendDownwards;
						if (largerOf2Sums > maxSum) {
							System.out.println("MaxSum " + maxSum
									+ " has been changed to " + largerOf2Sums);
							maxSum = largerOf2Sums;

						}
					}
				}
			}

			placeAlongDiagonal ++;
		}
		System.out.println("Program ran for " +(System.currentTimeMillis()- start)/1000 + " seconds.");
		return maxSum;
	}

	private int findSubMatrixSum(int x1, int y1, int x2, int y2) {
		int sum = 0;
		for (int i = x1; i <= x2; i++) {
			for (int k = y1; k <= y2; k++) {
				sum += matrix[i][k];

			}

		}

		return sum;
	}

	public Integer[][] getMatrix() {
		return matrix;
	}

	public static void main(String[] args) throws FileNotFoundException {
		MaxSum a = new MaxSum();
		System.out.println("Max Sum is " + a.findMaxSum());

	}
}
