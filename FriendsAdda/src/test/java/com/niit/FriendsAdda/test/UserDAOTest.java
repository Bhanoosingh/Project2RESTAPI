package com.niit.FriendsAdda.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.FriendsAdda.DAO.UserDAO;
import com.niit.FriendsAdda.model.UserDetail;

public class UserDAOTest {

	static UserDetail user;
	static UserDAO userDao;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user =new UserDetail();
		userDao = (UserDAO) context.getBean("userDAO");
	} 
	
	/*@Test
	public void addUserTest(){
		user.setName("Bhanoo");
		user.setPassword("@123");
		user.setEmail("bhanoosinghpacex1@gmail.com");
		user.setRole("Admin");
		user.setAddress("Lucknow");
		user.setPhone("8960992608");
		assertEquals("Problem in adding user into the table", true, userDao.addUser(user));
		
		System.out.println("<-----------Successfully added into user-------->");
	}*/

	/*@Test
	public void updateUserTest() {
		
		user.setName("Bhanoo");
		user.setPassword("@123");
		user.setEmail("bhanoosinghpacex1@gmail.com");
		user.setRole("Admin");
		user.setAddress("Lucknow");
		user.setPhone("8960992608");
		user.setEnabled(true);
		assertEquals("Problem in updating status of forum", true, userDao.updateUser(user));
		
		System.out.println("<-----------Successfully updated into user-------->");
	}*/
	
	/*@Test
	public void deleteForumTest() {
		
		user.setEmail("bhanoosinghpacex1@gmail.com");
		assertEquals("Problem in deleting job", true, userDao.deleteUser(user));
		
		System.out.println("<-----------Successfully deleted user-------->");
	}*/
	
	/*@Test
	public void getUserTest() {
		
		assertEquals("Problem in retrieving record",true,userDao.getUser("bhanoosinghpacex1@gmail.com"));
	}*/
}
