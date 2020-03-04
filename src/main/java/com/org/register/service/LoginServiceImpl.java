package com.org.register.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.LoginDAO;
import com.org.register.dao.RegisterDAO;
import com.org.register.dao.RegisterDAOImpl;
import com.org.register.dto.LoginDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LoginService {
	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Autowired
	private LoginDAO dao;

	public LoginServiceImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public boolean validateLogin(LoginDTO dto) {
		boolean valid = false;
		try {
			logger.info("invoked login....");

			if (Objects.nonNull(dto)) {
				logger.info("starting validation for " + dto);

				String Email = dto.getEmail();
				if (Email != null && !Email.isEmpty() && Email.length() >= 10) {
					logger.info("Email is valid");
					valid = true;
				} else

				{
					logger.info("Email is invalid");
					valid = false;
				}
			}
			String Password = dto.getPassword();
			if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
				logger.info("Password is valid");
				valid = true;
			} else {
				logger.info("Password is invalid");
				valid = false;
			}
			if (valid)

				logger.info("Data is valid ,will convert  to entity");

			RegisterEntity regEntity = new RegisterEntity();
			BeanUtils.copyProperties(dto, regEntity);

			RegisterEntity regEntity1 = dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());

			if (regEntity1 != null) {
				logger.info("Entity is ready \t" + regEntity);
				// dao.save(regEntity);
				// System.out.println("Entity is saved");
				dao.fetchByEmailAndPassword(dto.getEmail(), dto.getPassword());
				logger.info("user details exists");
				return true;
			} else {
				logger.info("user not exist");
			}
			return false;

		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
		}

		return valid;
	}
}
