package com.comresource.myapp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.comresource.model.Dimension;
import com.comresource.service.DimensionService;

// TODO: Auto-generated Javadoc
/**
 * The Class DimensionController.
 */
@Controller
public class DimensionController {
	
	/** The dimension service. */
	@Autowired 
	private DimensionService dimensionService;
	
	/**
	 * Sets the dimension.
	 *
	 * @param dimension the dimension
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/setdimension", method = RequestMethod.POST)
	public String setDimension(@ModelAttribute("dimension") Dimension dimension, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "error";
		}
		int row = dimension.getRow();
		int col = dimension.getCol();
		if(row==0 || col==0){
			model.addAttribute("reenter","ROW or COLUMN cant be zero");
			return "home";
		}
	
		dimension.setArrayDisplay(dimensionService.getArrayDisplay(row,col));
		if(dimension.getArrayDisplay().isEmpty()){
			model.addAttribute("reenter","Array is Empty");
			return "home";
		}

		model.addAttribute("dimension", dimension);
		return "tableView";

	}

}
