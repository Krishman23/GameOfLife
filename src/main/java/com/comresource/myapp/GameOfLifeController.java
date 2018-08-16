package com.comresource.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comresource.model.Dimension;
import com.comresource.service.GameOfLifeService;
// TODO: Auto-generated Javadoc

/**
 * The Class GameOfLifeController.
 */
@Controller
public class GameOfLifeController {
	
	/** The game of life service. */
	@Autowired
	private GameOfLifeService gameOfLifeService;
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAutoGrowCollectionLimit(1000); //as the size of the array increases need to increase the size of collection limit
	}
	
	/**
	 * Start gameof life.
	 *
	 * @param dimension the dimension
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/startGameofLife", method = RequestMethod.POST)
	public String startGameofLife(@ModelAttribute("dimension") Dimension dimension, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "error";
		}
		
		//make sure the loop is valid 
		if (dimension.getItr() > 0) {
			//convert 1D arraylist to 2D array (easy for calculation)
			int[][] arrayInput = gameOfLifeService.getArrayInput(dimension);
			//set next generation 
			List<Integer> nextGeneration = gameOfLifeService.setNextGeneration(arrayInput);
			dimension.setArrayDisplay(nextGeneration);
			dimension.setItr(dimension.getItr() - 1); 
		
		}
		model.addAttribute("dimension", dimension);
		return "tableView";

	}

	

	
}
