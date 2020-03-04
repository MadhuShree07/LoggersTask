package com.org.register.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.ForgotDAO;
import com.org.register.dao.RegisterDAO;
import com.org.register.dao.RegisterDAOImpl;
import com.org.register.dto.ForgotDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class ForgotServiceImpl implements ForgotService {
	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Autowired
	private ForgotDAO dao;

	public ForgotServiceImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public boolean validateForgotPassword(ForgotDTO dto) {
		boolean valid = false;
		try {
			logger.info(" invoked validateForgot....");

			if (Objects.nonNull(dto)) {
				logger.info("starting validation for " + dto);

				String Email = dto.getEmail();

				if (Email != null && Email.contains("@") && Email.length() >= 10) {
					logger.info("Email is valid");
					valid = true;
					String Password = dto.getPassword();

					if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
						logger.info("Password is valid");
						valid = true;

						String ConfirmPassword = dto.getConfirmPassword();
						if (valid && ConfirmPassword != null && !ConfirmPassword.isEmpty()
								&& ConfirmPassword.length() >= 6) {
							logger.info("ConfirmPassword is valid");
							valid = true;

						} else {
							logger.info("ConfirmPassword is invalid becuase its not same");
							valid = false;

						}

					} else {

						logger.info("Password is invalid");
						valid = false;

					}
				} else {
					logger.info("Email is invalid");
					valid = false;

				}

			}

			return valid;
		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
		}
		return valid;

	}

	public String validateForgot(ForgotDTO dto) {

		RegisterEntity regEntity = new RegisterEntity();

		RegisterEntity regEntity1 = dao.fetchByEmail(dto.getEmail(), dto.getPassword());
		if (Objects.nonNull(regEntity1)) {

			logger.info("Email Exist" + regEntity1);

		} else {
			logger.info("Email doesnt exist");
		}
		return null;
	}
}
