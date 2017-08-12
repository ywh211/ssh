package com.ywh.dao.impl;

import org.hibernate.SessionFactory;

import com.ywh.dao.UserDao;
import com.ywh.bean.User;

public class UserDaoImpl implements UserDao {
private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
}
