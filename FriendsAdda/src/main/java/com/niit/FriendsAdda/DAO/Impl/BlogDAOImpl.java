package com.niit.FriendsAdda.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FriendsAdda.DAO.BlogDAO;
import com.niit.FriendsAdda.model.Blog;
import com.niit.FriendsAdda.model.BlogComment;

@SuppressWarnings("deprecation")
@Repository
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addBlog(Blog blog) {
		
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	@Transactional
	public boolean updateBlog(Blog blog) {

		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}

	public Blog getBlog(int blogId) {
		
		try {
			Session session = sessionFactory.openSession();
			Blog blog = session.get(Blog.class, blogId);
			return blog;
		}catch(Exception exception) {
			return null;
		}
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		
		try {
			
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}
	
	@Transactional
	public boolean rejectBlog(Blog blog) {
		
		try {
			
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception exception) {
			return false;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Blog> listBlog(String userName){
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Blog> blogList = new ArrayList<Blog>();
			Query query = session.createQuery("FROM Blog where username=:username").setString("username",userName);
			blogList = query.list();
			return blogList;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean incrementLike(Blog blog) {
		
		try {
			
			int likes = blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception ex) {
			
			return false;
		}
	}

	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public BlogComment getBlogComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class,commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		} 
	}

	@SuppressWarnings({ "rawtypes" })
	public List<BlogComment> listBlogComments(int blogid) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogid));
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}
	
}
