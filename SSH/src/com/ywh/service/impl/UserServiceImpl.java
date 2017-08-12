package com.ywh.service.impl;

import org.hibernate.SessionFactory;

import com.ywh.dao.UserDao;
import com.ywh.bean.User;
import com.ywh.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		if (user == null) {
			System.out.println("user is null");
		}
		else{
			userDao.saveUser(user);

		}
	}

}
