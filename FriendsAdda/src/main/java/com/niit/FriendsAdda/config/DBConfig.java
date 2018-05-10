package com.niit.FriendsAdda.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.FriendsAdda.DAO.BlogDAO;
import com.niit.FriendsAdda.DAO.ForumDAO;
import com.niit.FriendsAdda.DAO.JobDAO;
import com.niit.FriendsAdda.DAO.ProfilePicDAO;
import com.niit.FriendsAdda.DAO.UserDAO;
import com.niit.FriendsAdda.DAO.Impl.BlogDAOImpl;
import com.niit.FriendsAdda.DAO.Impl.ForumDAOImpl;
import com.niit.FriendsAdda.DAO.Impl.JobDAOImpl;
import com.niit.FriendsAdda.DAO.Impl.ProfilePicDAOImpl;
import com.niit.FriendsAdda.DAO.Impl.UserDAOImpl;
import com.niit.FriendsAdda.model.ApplyJob;
import com.niit.FriendsAdda.model.Blog;
import com.niit.FriendsAdda.model.BlogComment;
import com.niit.FriendsAdda.model.Forum;
import com.niit.FriendsAdda.model.ForumComment;
import com.niit.FriendsAdda.model.Friend;
import com.niit.FriendsAdda.model.Job;
import com.niit.FriendsAdda.model.Message;
import com.niit.FriendsAdda.model.ProfilePicture;
import com.niit.FriendsAdda.model.UserDetail;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {

	// 1.Data Source Object
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("system");
		dataSource.setPassword("oracle123");

		return dataSource;
	}

	// 2.Create SessionFactory Bean
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProp = new Properties();
		
		System.out.println("Hibernate Properties Object Creating");
		
		// Tells weather we want to create the table automatically or we want to use
		// exsiting table.	
		hibernateProp.put("hibernate.hbmddl2.auto", "update"); // we can use create ,update ,create drop as value here.
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");// we can use any oracle
		hibernateProp.put("hibernate.show_sql","true");																					// version 10g,11g,12c
		hibernateProp.put("hibernate.format_sql","true");
		
		System.out.println("Local Session Factory Builder Object Creating");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addAnnotatedClass(Message.class);
		sessionFactoryBuilder.addAnnotatedClass(Friend.class);
		sessionFactoryBuilder.addAnnotatedClass(ApplyJob.class);
		System.out.println("=== Tables Created ===");
		SessionFactory sessionFectory = sessionFactoryBuilder.buildSessionFactory(); 
		
		return sessionFectory;
		
	}	
	
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		
		return new BlogDAOImpl();
	}
	
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO() {
		
		return new ForumDAOImpl();
	}
	
	@Bean(name="jobDAO")
	public JobDAO getjobDAO() {
		
		return new JobDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO() {
		
		return new UserDAOImpl();
	}
	
	@Bean(name = "profileDAO")
	public ProfilePicDAO getProfilePictureDAO() {
		return new ProfilePicDAOImpl();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
		return new HibernateTransactionManager(sessionFactory);
	}
}
