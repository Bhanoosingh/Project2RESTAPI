package com.niit.FriendsAdda.DAO;

import com.niit.FriendsAdda.model.ProfilePicture;

public interface ProfilePicDAO {

	public void save(ProfilePicture profilePicture);

	public ProfilePicture getProfilePicture(String loginname);
}
