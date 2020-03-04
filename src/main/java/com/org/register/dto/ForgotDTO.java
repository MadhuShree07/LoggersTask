package com.org.register.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.org.register.dao.RegisterDAOImpl;

import lombok.Data;

@Component
@Data
public class ForgotDTO {
	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	private String email;
	private String password;
	private String confirmPassword;

	public ForgotDTO() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}
}
