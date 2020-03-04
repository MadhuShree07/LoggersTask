package com.org.register.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

public class RegisterDTO {
	private static Logger logger = Logger.getLogger(RegisterDTO.class);

	private String userName;
	private String email;
	private long phnNum;
	private String password;
	private String confirmPassword;

	public RegisterDTO() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

}
