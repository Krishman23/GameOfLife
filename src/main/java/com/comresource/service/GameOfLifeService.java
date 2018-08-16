package com.comresource.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.comresource.model.Dimension;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOfLifeService.
 */
@Service
public class GameOfLifeService {

	/**
	 * Gets the array input.
	 *
	 * @param dimension the dimension
	 * @return the array input
	 */
	public int[][] getArrayInput(Dimension dimension) {
		
		List<Integer> arrListInput = dimension.getArrayDisplay();
		int row = dimension.getRow();
		int col = dimension.getCol();
		int count = 0;
		int[][] arrayInput = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arrayInput[i][j] = arrListInput.get(count);
				count++;
			}
		}
		return arrayInput;
	}

	/**
	 * Sets the next generation.
	 *
	 * @param arrayInput the array input
	 * @return the array list
	 */
	public List<Integer> setNextGeneration(int[][] arrayInput) {
		// TODO Auto-generated method stub
		List<Integer> nextGen = new ArrayList<Integer>();
		int row = arrayInput.length;
		int col = arrayInput[0].length;
		int count = 0;
		int[] neighbours = new int[8];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				count= countLiveNeighbours(i,j,arrayInput );
				// dead condition if less than eq 1 or greater than eq 4
				if (count <= 1 || count >= 4) {
					nextGen.add(0);
				}

				// if currently alive and live neighbours is 2 the remain alive
				else if (arrayInput[i][j] == 1 && count == 2) {
					nextGen.add(1);
				}

				// if total neighbour is 3 then dead/ alive becomes alive
				else if (count == 3) {
					nextGen.add(1);
				}
				// if nothin then dead
				else {
					nextGen.add(0);
				}

				// reset count for next position
				count = 0;
			}

		}

		return nextGen;

	}
	// to find 8 neighbours, we need +/- 1 coordinate of current
	// position
	
	/**
	 * Count live neighbours.
	 *
	 * @param i the i
	 * @param j the j
	 * @param arrayInput the array input
	 * @return the int
	 */
	private int countLiveNeighbours(int i, int j, int[][] arrayInput ){
		int row = arrayInput.length;
		int col = arrayInput[0].length;
		int startPosX = (i - 1 < 0) ? i : i - 1;
		int startPosY = (j - 1 < 0) ? j : j - 1;
		int endPosX = (i + 1 >= row) ? i : i + 1;
		int endPosY = (j + 1 >= col) ? j : j + 1;
		int count=0;
		// find neighbours and See how many are alive.
		for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
			for (int colNum = startPosY; colNum <= endPosY; colNum++) {
				if (!(rowNum == i && colNum == j)) {
					// since dead is 0 and alive is 1, therefore, total
					// count = alive
					count += arrayInput[rowNum][colNum];
				}

			}

		}
		return count;
	}
}
