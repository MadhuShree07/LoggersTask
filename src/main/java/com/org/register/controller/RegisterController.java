package com.org.register.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.RegisterDTO;
import com.org.register.service.RegisterService;

@Controller
@RequestMapping
public class RegisterController {

	private static Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private RegisterService service;

	public RegisterController() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	@RequestMapping("/register.do")
	public String onRegister(RegisterDTO dto, ModelMap map) {
		try {
			logger.info("Invoked onRegister method");
			logger.info(dto);

			boolean check = this.service.validateAndSave(dto);

			if (check) {
				ModelMap ma = map.addAttribute("name", dto.getUserName());
				ModelMap success = map.addAttribute("successMessage", " Your data is saved !!!");
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "Failure:Data not Saved");
			}

		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
		}

		return "reg";
	}
}
