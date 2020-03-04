package com.org.register.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LoginDTO {
	private static Logger logger = Logger.getLogger(RegisterDTO.class);

	private String email;
	private String password;

	public LoginDTO() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

}
