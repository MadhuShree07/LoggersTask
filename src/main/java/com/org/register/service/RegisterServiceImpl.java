package com.org.register.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.RegisterDAO;
import com.org.register.dao.RegisterDAOImpl;
import com.org.register.dto.RegisterDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class RegisterServiceImpl implements RegisterService {
	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Autowired
	private RegisterDAO dao;

	public RegisterServiceImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public boolean validateAndSave(RegisterDTO dto) {
		boolean valid = false;
		try {
			logger.info("save invoked....");

			if (Objects.nonNull(dto)) {
				logger.info("starting validation for " + dto);
				String Username = dto.getUserName();

				if (Username != null && !Username.isEmpty() && Username.length() >= 5) {
					logger.info("Username is valid");
					valid = true;
				} else {
					logger.info("Username is invalid");
					if (Username == null) {
						logger.info("Username is null");
					}
					if (Username != null && Username.length() < 5) {
						logger.info("name length is less than 5");
					}
					valid = false;
				}

				String Email = dto.getEmail();

				if (valid && Email != null && !Email.isEmpty() && Email.length() >= 10) {
					logger.info("Email is valid");
					valid = true;
				} else {
					logger.info("Email is invalid");
					valid = false;
				}

				String Password = dto.getPassword();

				if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
					logger.info("Password is valid");
					valid = true;
				} else {

					logger.info("Password is invalid");
					valid = false;

				}

				String ConfirmPassword = dto.getConfirmPassword();
				if (valid && ConfirmPassword != null && !ConfirmPassword.isEmpty() && ConfirmPassword.length() >= 6) {
					logger.info("ConfirmPassword is valid");
					valid = true;
				} else {
					logger.info("ConfirmPassword is invalid becuase its not same");
					valid = false;

				}
			}
//check pwd and confirm pwd
			if (valid) {
				logger.info("Data is valid ,will convert  to entity");

				RegisterEntity regEntity = new RegisterEntity();
				BeanUtils.copyProperties(dto, regEntity);

				RegisterEntity regEntity1 = dao.fetchByEmail(dto.getEmail());
				RegisterEntity regEntity2 = dao.fetchByEmail(dto.getUserName());
				if (regEntity2 == null && regEntity1 == null) {
					logger.info("Entity is ready \t" + regEntity);
					dao.save(regEntity);
					logger.info("Entity is saved");
				} else {
					logger.info("DATA NOT VALID ,NOT SAVED IN DATABASE");
				}
				return valid;
			}
		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
		}
		return false;
	}
}