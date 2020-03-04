package com.org.register.dao;

import com.org.register.entity.RegisterEntity;

public interface LoginDAO {

	public RegisterEntity fetchByEmailAndPassword(String mail, String pwd);
}
