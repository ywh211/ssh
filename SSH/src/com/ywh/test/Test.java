package com.ywh.test;

import static org.junit.Assert.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ywh.bean.User;
import com.ywh.service.UserService;

public class Test {
	@org.junit.Test
	public void fun1() throws Exception {
		 
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) ac.getBean("userService");
		 
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("123");
		us.saveUser(user);
		
	}

	
}
