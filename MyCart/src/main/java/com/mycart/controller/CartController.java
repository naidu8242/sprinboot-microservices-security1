package com.mycart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	 @Value("${manage.url}")
	 private String todoUrl;
	 
	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public ModelAndView showMyCartPage() {
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("todoUrl", todoUrl);
	return mav;
	}
 
	@RequestMapping(value = "/myWishlist", method = RequestMethod.GET)
	public ModelAndView showWishListPage(ModelMap model) {
		ModelAndView mav = new ModelAndView("wishlist");
		mav.addObject("todoUrl", todoUrl);
	return mav;
	}
	
}
