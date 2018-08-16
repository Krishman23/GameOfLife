package com.comresource.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class DimensionServiceTest.
 */
public class DimensionServiceTest {

	/** The dimension service. */
	@Autowired
	private DimensionService dimensionService;

	/**
	 * Gets the array display test.
	 *
	 * @return the array display test
	 */
	@Test
	public void getArrayDisplayTest() {
		
		List<Integer> arrListInput = dimensionService.getArrayDisplay(9, 0);
		List<Integer> arrListExpected =new ArrayList<Integer>();
		assertEquals(arrListExpected, arrListInput);
		
		arrListInput = dimensionService.getArrayDisplay(5, 5);
		arrListExpected = new ArrayList<Integer>(Collections.nCopies(25, 0));
		assertEquals(arrListExpected, arrListInput);
		
	}

}
