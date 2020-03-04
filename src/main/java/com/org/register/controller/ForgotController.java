package com.org.register.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.ForgotDTO;
import com.org.register.service.ForgotService;

@Component
@RequestMapping
public class ForgotController {
	private static Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private ForgotService service;

	public ForgotController() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	@RequestMapping("/forgot.do")
	public String onForgot(ForgotDTO dto, ModelMap map) {
		try {
			logger.info("inside getMessage()...Invoked onForgot method");
			logger.info("inside getMessage()..." + dto);

			boolean valid = this.service.validateForgotPassword(dto);
			if (!valid) {
				String entity = this.service.validateForgot(dto);
				boolean valid = this.service.validateForgotPassword(dto);
			if (!valid) {
				String entity = this.service.validateForgot(dto);
				if (Objects.nonNull(entity)) {

					ModelMap email = map.addAttribute("Invalid mail",
							"Email not valid and passwords not matched");

				} else {
					ModelMap pass = map.addAttribute("Password not Matched ", "enter again");
				}

			} else {

				String entity1 = this.service.validateForgot(dto);
				if (!Objects.nonNull(entity1)) {
					ModelMap newPassword = map.addAttribute("Success", "Password changed successfully");
				} else {
					ModelMap mail = map.addAttribute("email is not valid", "mail is not valid");

				}

			}

		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
		}
		return "Forgot";
	}
}
