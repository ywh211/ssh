package com.ywh.service.impl;

import java.util.List;

import com.ywh.bean.AdminUser;
import com.ywh.dao.AdminUserDao;
import com.ywh.page.Page;
import com.ywh.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService{
    //业务逻辑层调用数据持久层的接口
	private AdminUserDao adminUserDao;
	//提供一个SET方法进入注入 
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		adminUserDao.saveAdminUser(adminUser);
		
	}

	@Override
	public void updateAdminUser(AdminUser adminUser) {
		adminUserDao.updateAdminUser(adminUser);
		
	}

	@Override
	public void deleteAdminUserById(AdminUser adminUser) {
		adminUserDao.deleteAdminUserById(adminUser);
		
	}

	@Override

	public Page findAdminUserList(int currentPage,int pageSize){
		//调用数据持久层的findAdminUserList方法
		Page page = adminUserDao.findAdminUserList(currentPage,pageSize);
		return page;
	}

	@Override
	public AdminUser findAdminById(int id) {
		AdminUser admin = adminUserDao.findAdminById(id);
		return admin;
	}

}
