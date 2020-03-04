package com.org.register.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.register.controller.RegisterController;
import com.org.register.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {
	private Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LoginDAOImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public RegisterEntity fetchByEmailAndPassword(String mail, String pwd) {

		Session session = null;

		try {
			session = factory.openSession();
			logger.info("invoke program...");

			Query query = session.getNamedQuery("fetchByEmailAndPassword");

			query.setParameter("email", mail);
			query.setParameter("password", pwd);
			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				logger.info("Entity found" + "\t" + mail + "\t" + pwd);
				RegisterEntity entity = (RegisterEntity) result;
				return entity;
			} else {
				logger.info("Entity not found");
				return null;
			}

		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);

		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
		return null;
	}
}