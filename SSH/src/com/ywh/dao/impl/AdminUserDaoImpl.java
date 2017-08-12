package com.ywh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ywh.bean.AdminUser;
import com.ywh.dao.AdminUserDao;
import com.ywh.page.Page;

public class AdminUserDaoImpl implements AdminUserDao{
    private SessionFactory sessionFactory;
    //提供一个SET方法进行注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//得到session的方法
	public Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) { 
		getSession().save(adminUser);
	}

	@Override
	public void updateAdminUser(AdminUser adminUser) { 
		getSession().update(adminUser);
	}

	@Override
	public void deleteAdminUserById(AdminUser adminUser) { 
		getSession().delete(adminUser);
	}

	@Override
	public Page findAdminUserList(int currentPage,int pageSize) { 
		Query query = getSession().createQuery("from AdminUser");
		List<AdminUser> data1 = query.list(); 
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);  
		List<AdminUser> data2 = query.list(); 
		
		Page page = new Page(data2);
		page.setAllRow(data1.size());
		page.setPageSize(pageSize);
		page.setTotalPage();
		page.setCurrentPage(currentPage);	 
		page.isHasNextPage();
		page.isHasPrePage();
		return page;
	}
	@Override
	public AdminUser findAdminById(int id) {
		Query query = getSession().createQuery("from AdminUser a where a.id="+id);
		AdminUser admin = (AdminUser) query.list().get(0);
		return admin;
	}

}
