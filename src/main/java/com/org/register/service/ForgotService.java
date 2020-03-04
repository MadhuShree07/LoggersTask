package com.org.register.service;

import com.org.register.dto.ForgotDTO;

public interface ForgotService {
	
	public boolean validateForgotPassword(ForgotDTO dto);
	public String validateForgot(ForgotDTO dto);

}
