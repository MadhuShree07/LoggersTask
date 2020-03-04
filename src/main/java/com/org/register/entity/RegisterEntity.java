package com.org.register.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.org.register.dao.RegisterDAOImpl;

import lombok.Data;

@Entity
@Table(name = "registerForm")
@Data
@NamedQueries({
		@NamedQuery(name = "updatePasswordByEmail", query = "update RegisterEntity re set re.password=:password where re.email=:email"),
		@NamedQuery(name = "fetchByEmail", query = "select re from RegisterEntity re where re.email=:email"),
		@NamedQuery(name = "fetchByEmailAndPassword", query = "select re from RegisterEntity re where re.email=:email and re.password=:password") })

public class RegisterEntity implements Serializable {

	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Id
	@GenericGenerator(name = "madhu", strategy = "increment")
	@GeneratedValue(generator = "madhu")
	@Column(name = "id")
	private int id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "phnNum")
	private long phnNum;
	@Column(name = "password")
	private String password;

	public RegisterEntity() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}
}
