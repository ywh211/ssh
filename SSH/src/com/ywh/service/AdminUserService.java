package com.ywh.service;

import java.util.List;

import com.ywh.bean.AdminUser;
import com.ywh.page.Page;

public interface AdminUserService { 
	public void saveAdminUser(AdminUser adminUser);
	public void updateAdminUser(AdminUser adminUser);
	public void deleteAdminUserById(AdminUser adminUser);
	public Page findAdminUserList(int currentPage,int pageSize);
	public AdminUser findAdminById(int id);
}
