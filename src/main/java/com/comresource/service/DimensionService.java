package com.comresource.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class DimensionService.
 */
@Service("DimensionService")
public class DimensionService {

	/**
	 * Gets the array display.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the array display
	 */
	public static List<Integer> getArrayDisplay(int row, int col) {
		List<Integer> arrData = new ArrayList<Integer>(Collections.nCopies(row*col, 0));
		return arrData;
	}
}
