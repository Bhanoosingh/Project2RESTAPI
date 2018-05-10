package com.niit.FriendsAdda.DAO;

import java.util.List;

import com.niit.FriendsAdda.model.Forum;
import com.niit.FriendsAdda.model.ForumComment;

public interface ForumDAO {

	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> listForum(String userName);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
    
    public boolean addForumDiscussion(ForumComment forumComment);
    public boolean deleteForumDiscussion(ForumComment forumComment);
    public ForumComment getForumDiscussion(int discussionId);
    public List<ForumComment> listForumDiscussion(int forumid);
}
