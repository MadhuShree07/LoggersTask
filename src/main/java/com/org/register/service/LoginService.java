package com.org.register.service;

import com.org.register.dto.LoginDTO;

public interface LoginService {

	public boolean validateLogin(LoginDTO dto);
}
