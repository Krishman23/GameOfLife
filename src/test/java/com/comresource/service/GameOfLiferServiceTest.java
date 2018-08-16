package com.comresource.service;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.comresource.model.Dimension;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOfLiferServiceTest.
 */
public class GameOfLiferServiceTest  {

	
	/** The game of life service. */
	public GameOfLifeService gameOfLifeService=new GameOfLifeService();

	/** The dimension. */
	public Dimension dimension;
	
	/** The arr list input. */
	ArrayList<Integer> arrListInput = new ArrayList<Integer>();

	/**
	 * Before.
	 *
	 * @throws Exception the exception
	 */
	@Before 
	public void before() throws Exception {
		dimension = new Dimension();
		dimension.setRow(6);
		dimension.setCol(4);
		for (int i = 0; i < 24; i++) {
			arrListInput.add(1);// ThreadLocalRandom.current().nextInt(1, 9 + 1)
		}
		dimension.setArrayDisplay(arrListInput);
		dimension.setItr(5);
		dimension.setItrSpeed(1000);
		
	}

	/**
	 * Gets the array input test.
	 *
	 * @return the array input test
	 */
	@Test
	public void getArrayInputTest() {
		int[][] arrDisplayExpected = new int[6][4];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				arrDisplayExpected[i][j] = 1;
			}
		}
		int[][] arrDisplayInput = gameOfLifeService.getArrayInput(dimension);
		assertEquals(arrDisplayExpected, arrDisplayInput);
	}

	/**
	 * Sets the next gen neighbours test.
	 */
	@Test
	public void setNextGenNeighboursTest(){
		/*
		 * 0 0 0     0 1 0
		 * 1 1 1  => 0 1 0 
		 * 0 0 0     0 1 0 
		 */
		int[][] arrDisplayInput = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arrDisplayInput[i][j] =((i==1)? 1: 0);
				}
				
			}
	
		List<Integer> arrListInput = gameOfLifeService.setNextGeneration(arrDisplayInput);
	
		ArrayList<Integer> arrListExpected=new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if((i+2)<=9 && (i+2) %3==0 )
			{arrListExpected.add(1);}
			else 
			{arrListExpected.add(0);}
				
			}
	
	assertEquals(arrListExpected, arrListInput);	
		
	}
	
	
}
