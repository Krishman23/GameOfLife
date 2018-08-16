package com.comresource.myapp;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.comresource.model.Dimension;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param dimension the dimension
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("dimension") Dimension dimension, Locale locale, Model model) {
		return "home";
	}



}
