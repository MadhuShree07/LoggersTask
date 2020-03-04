package com.org.register.dao;

import com.org.register.entity.RegisterEntity;

public interface ForgotDAO {

	public RegisterEntity fetchByEmail(String email, String pwd);
	// public RegisterEntity updatePasswordByEmail(String pwd, String mail);
}
