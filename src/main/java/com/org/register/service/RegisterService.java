package com.org.register.service;

import com.org.register.dto.RegisterDTO;

public interface RegisterService {

	public boolean validateAndSave(RegisterDTO dto);

}
