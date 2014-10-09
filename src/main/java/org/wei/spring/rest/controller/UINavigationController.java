package org.wei.spring.rest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UINavigationController {

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView index(Locale locale) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("time", getLocalTime(locale));
		return mav;
	}

	@RequestMapping(value = { "/charts" }, method = RequestMethod.GET)
	public ModelAndView charts(Locale locale) {
		ModelAndView mav = new ModelAndView("charts");
		return mav;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView search(Locale locale) {
		ModelAndView mav = new ModelAndView("search");
		return mav;
	}

	@RequestMapping(value = { "/imdb" }, method = RequestMethod.GET)
	public ModelAndView imdb(Locale locale) {
		ModelAndView mav = new ModelAndView("imdb");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	private String getLocalTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		return dateFormat.format(date);
	}

}
