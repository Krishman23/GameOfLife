package com.comresource.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Dimension.
 */
public class Dimension {
	 	
	 	/** The row. */
	 	private int row;
	    
    	/** The col. */
    	private int col;
	    
    	/** The itr. */
    	private int itr;
	    
    	/** The itr speed. */
    	private int itrSpeed;
	    
    	/** The array display. */
    	private List<Integer> arrayDisplay;
	    
	    /**
    	 * Gets the itr speed.
    	 *
    	 * @return the itr speed
    	 */
    	public int getItrSpeed() {
			return itrSpeed;
		}
		
		/**
		 * Sets the itr speed.
		 *
		 * @param itrSpeed the new itr speed
		 */
		public void setItrSpeed(int itrSpeed) {
			this.itrSpeed = itrSpeed;
		}
		
		/**
		 * Gets the row.
		 *
		 * @return the row
		 */
		public int getRow() {
			return row;
		}
		
		/**
		 * Sets the row.
		 *
		 * @param row the new row
		 */
		public void setRow(int row) {
			this.row = row;
		}
		
		/**
		 * Gets the col.
		 *
		 * @return the col
		 */
		public int getCol() {
			return col;
		}
		
		/**
		 * Sets the col.
		 *
		 * @param col the new col
		 */
		public void setCol(int col) {
			this.col = col;
		}
		
		/**
		 * Gets the itr.
		 *
		 * @return the itr
		 */
		public int getItr() {
			return itr;
		}
		
		/**
		 * Sets the itr.
		 *
		 * @param itr the new itr
		 */
		public void setItr(int itr) {
			this.itr = itr;
		}
		
		/**
		 * Gets the array display.
		 *
		 * @return the array display
		 */
		public List<Integer> getArrayDisplay() {
			return arrayDisplay;
		}
		
		/**
		 * Sets the array display.
		 *
		 * @param arrayDisplay the new array display
		 */
		public void setArrayDisplay(List<Integer> arrayDisplay) {
			this.arrayDisplay = arrayDisplay;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return this.row+", "+this.col+", "+this.arrayDisplay;
		}
			 
}
