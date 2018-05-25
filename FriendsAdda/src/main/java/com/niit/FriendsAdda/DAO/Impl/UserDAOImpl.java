package com.niit.FriendsAdda.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FriendsAdda.DAO.UserDAO;
import com.niit.FriendsAdda.model.UserDetail;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	
	public boolean addUser(UserDetail user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	
	public boolean updateUser(UserDetail user) {
		
		try {
			System.out.println(user.getEmail());
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	
	public boolean deleteUser(UserDetail user) {
		
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	
	public UserDetail getUser(String userId) {
		
		try {
			Session session = sessionFactory.openSession();
			UserDetail user = session.get(UserDetail.class, userId);
			return user;
		}catch(Exception exception) {
			return null;
		}
	}

	
	public boolean checkLogin(UserDetail user) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetail where email=:email and password=:password");
			query.setParameter("email",user.getEmail());
			query.setParameter("password",user.getPassword());
			UserDetail userDetails=(UserDetail)query.list().get(0);
			session.close();
			if(userDetails==null){
				return false;
			}else
			{
			 return true;
			}
		}catch (Exception e) {
			return false;
		}
	}

	
	public boolean updateOnlineStatus(String status, UserDetail user) {
		try {
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
	public List<UserDetail> listUser() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<UserDetail> userList = new ArrayList<UserDetail>();
			Query query = session.createQuery("FROM UserDetail");
			userList = query.list();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

}
