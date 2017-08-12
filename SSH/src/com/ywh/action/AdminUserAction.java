package com.ywh.action;

import java.util.List;

import com.ywh.bean.AdminUser;
import com.ywh.page.Page;
import com.ywh.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport{ 
	//需要调用业务逻辑层的接口
	private AdminUserService  adminUserService;
	private int id;
	private int ids[];
	private String username;
	private String password;
	private AdminUser adminUser;
	//当前的页
	private int currentPage=1;
	//每页显示的数量
	private int paseSize=5; 
	//用来接收查找到的数据
	private Page page;  
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}  

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPaseSize() {
		return paseSize;
	}
	public void setPaseSize(int paseSize) {
		this.paseSize = paseSize;
	}
	public Page getPage() {
		return page;
	} 
	public void setPage(Page page) {
		this.page = page;
	} 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AdminUser getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	public AdminUserService getAdminUserService() {
		return adminUserService;
	}
	//提供SET方法进入注入 
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public String execute() throws Exception { 
		//使用用业务逻辑层的接口调用查找所有管理员的方法
		page = adminUserService.findAdminUserList(currentPage,paseSize);  
		return SUCCESS;
	}
	
	//注册的方法
	public String register(){
		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.saveAdminUser(adminUser);
		return SUCCESS;
		
	}
	//通过id查找管理的信息
	public String findAdminById(){
		adminUser = adminUserService.findAdminById(id);
		return "updatetopage";
	}
	//修改
	public String updateAdmin(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.updateAdminUser(adminUser);
		return "updateok";
	}
	//删除
	public String deleteAdminById(){ 
		adminUser = adminUserService.findAdminById(id);
		adminUserService.deleteAdminUserById(adminUser); 
		return "ok";
	}
	//删除
	public String deleteAdminByIds(){ 
		for (int i = 0; i < ids.length; i++) { 
			adminUser = adminUserService.findAdminById(ids[i]);
			adminUserService.deleteAdminUserById(adminUser); 
		}
		return "ok";
	}
}
