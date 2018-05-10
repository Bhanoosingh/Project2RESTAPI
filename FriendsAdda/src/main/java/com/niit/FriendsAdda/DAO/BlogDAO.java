package com.niit.FriendsAdda.DAO;

import java.util.List;

import com.niit.FriendsAdda.model.Blog;
import com.niit.FriendsAdda.model.BlogComment;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public Blog getBlog(int blogId);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public List<Blog> listBlog(String userName);
	public boolean incrementLike(Blog blog);
    
    public boolean addBlogComment(BlogComment blogComment);
    public boolean deleteBlogComment(BlogComment blogComment);
    public BlogComment getBlogComment(int commentId);
    public List<BlogComment> listBlogComments(int blogid);
}
