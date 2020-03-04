package com.org.register.dao;

import java.io.Serializable;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.register.controller.RegisterController;
import com.org.register.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO {
	private static Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public RegisterDAOImpl() {
		logger.info("inside getMessage()...Invoked" + this.getClass().getSimpleName() + " obj created!");
	}

	public Serializable save(RegisterEntity entity) {

		Session session = null;
		try {

			logger.info("session created");
			session = factory.openSession();
			logger.info("Transaction begun");
			session.beginTransaction();
			logger.info("Entity saving...");
			session.save(entity);
			logger.info("Commiting....");
			session.getTransaction().commit();
			logger.info("Data saved");

		} catch (NumberFormatException e) {
			logger.info("INFO:" + e.getMessage());
		}

		return entity;

	}

	public RegisterEntity fetchByEmail(String email) {
		logger.info("Invoked fetchByName() ....");
		Session session = null;
		logger.info("Invoking save method");
		logger.info("info message -->  inside getMessage()....");
		logger.warn("warn message -->  inside getMessage()....");
		logger.error("error message -->  inside getMessage()....");

		try {
			session = factory.openSession();
			// session.getTransaction();
			logger.info("fetching...");
			String hql = "SELECT re from RegisterEntity re where email='" + email + "'";
			Query query = session.createQuery(hql);
			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				logger.info("Data found");
				RegisterEntity entity = (RegisterEntity) result;
				return entity;
				// return entity;
			} else {
				logger.info("Data not found");
				return null;
			}

		} catch (NumberFormatException e) {

			logger.error("--Exception occured--", e);
			logger.info("INFO:" + e.getMessage());
		}
		// return null;
		finally {
			session.close();

		}
		return null;
	}

}
