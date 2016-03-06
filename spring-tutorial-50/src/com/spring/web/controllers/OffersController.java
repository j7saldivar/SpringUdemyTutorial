package com.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.dao.Offer;
import com.spring.web.service.OffersService;

@Controller
public class OffersController {

	/*
	 * @RequestMapping("/") public String showHome(HttpSession session) {
	 * session.setAttribute("name", "barris"); return "home"; }
	 */

	/*
	 * @RequestMapping("/") public ModelAndView showHome() {
	 * 
	 * ModelAndView mv = new ModelAndView("home"); Map<String, Object> model =
	 * mv.getModel(); model.put("name", "barris"); return mv; }
	 */

	@Autowired
	private OffersService offersService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("ID: " + id);
		return "home";
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		offersService.throwTestException();
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		model.addAttribute("name", "model");
		return "offers";

	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";

	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer,
			BindingResult results) {

		if (results.hasErrors()) {

			List<ObjectError> errors = results.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";

		}

		offersService.create(offer);

		return "offercreated";

	}

}
