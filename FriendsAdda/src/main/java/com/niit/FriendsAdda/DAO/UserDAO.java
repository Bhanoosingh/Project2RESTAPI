package com.niit.FriendsAdda.DAO;

import java.util.List;

import com.niit.FriendsAdda.model.UserDetail;

public interface UserDAO {

	public boolean addUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public boolean deleteUser(UserDetail user);
	public UserDetail getUser(String userId);

	public boolean checkLogin(UserDetail user);
	public boolean updateOnlineStatus(String status,UserDetail user);
	public List<UserDetail> listUser();
}
