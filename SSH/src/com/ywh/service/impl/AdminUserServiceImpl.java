package com.ywh.service.impl;

import java.util.List;

import com.ywh.bean.AdminUser;
import com.ywh.dao.AdminUserDao;
import com.ywh.page.Page;
import com.ywh.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService{
    //ҵ���߼���������ݳ־ò�Ľӿ�
	private AdminUserDao adminUserDao;
	//�ṩһ��SET��������ע�� 
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
		//�������ݳ־ò��findAdminUserList����
		Page page = adminUserDao.findAdminUserList(currentPage,pageSize);
		return page;
	}

	@Override
	public AdminUser findAdminById(int id) {
		AdminUser admin = adminUserDao.findAdminById(id);
		return admin;
	}

}
