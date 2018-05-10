package com.niit.FriendsAdda.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="blogdiscussion_idseq", sequenceName="blogdiscussionid")
public class ForumComment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogdiscussion_idseq")
	int discussionId;
	
	String commentText;
	String userName;
	int forumId;
	Date discussionDate;
	
	public int getDiscussionId() {
		return discussionId;
	}
	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public Date getDiscussionDate() {
		return discussionDate;
	}
	public void setDiscussionDate(Date discussionDate) {
		this.discussionDate = discussionDate;
	}
}
