package com.org.register.dao;

import java.io.Serializable;

import com.org.register.entity.RegisterEntity;

public interface RegisterDAO {

	public Serializable save(RegisterEntity entity);

	public RegisterEntity fetchByEmail(String email);

}
