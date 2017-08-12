package com.ywh.action;

import java.util.List;

import com.ywh.bean.AdminUser;
import com.ywh.page.Page;
import com.ywh.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport{ 
	//��Ҫ����ҵ���߼���Ľӿ�
	private AdminUserService  adminUserService;
	private int id;
	private int ids[];
	private String username;
	private String password;
	private AdminUser adminUser;
	//��ǰ��ҳ
	private int currentPage=1;
	//ÿҳ��ʾ������
	private int paseSize=5; 
	//�������ղ��ҵ�������
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
	//�ṩSET��������ע�� 
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public String execute() throws Exception { 
		//ʹ����ҵ���߼���Ľӿڵ��ò������й���Ա�ķ���
		page = adminUserService.findAdminUserList(currentPage,paseSize);  
		return SUCCESS;
	}
	
	//ע��ķ���
	public String register(){
		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.saveAdminUser(adminUser);
		return SUCCESS;
		
	}
	//ͨ��id���ҹ������Ϣ
	public String findAdminById(){
		adminUser = adminUserService.findAdminById(id);
		return "updatetopage";
	}
	//�޸�
	public String updateAdmin(){
		AdminUser adminUser = new AdminUser();
		adminUser.setId(id);
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.updateAdminUser(adminUser);
		return "updateok";
	}
	//ɾ��
	public String deleteAdminById(){ 
		adminUser = adminUserService.findAdminById(id);
		adminUserService.deleteAdminUserById(adminUser); 
		return "ok";
	}
	//ɾ��
	public String deleteAdminByIds(){ 
		for (int i = 0; i < ids.length; i++) { 
			adminUser = adminUserService.findAdminById(ids[i]);
			adminUserService.deleteAdminUserById(adminUser); 
		}
		return "ok";
	}
}
