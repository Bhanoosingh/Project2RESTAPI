package com.niit.FriendsAdda.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.FriendsAdda.DAO.ForumDAO;
import com.niit.FriendsAdda.model.Forum;

public class ForumDAOTest {

	static Forum forum;
	static ForumDAO forumDao;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forum =new Forum();
		forumDao = (ForumDAO) context.getBean("forumDAO");
	} 
	
	/*@Test
	public void addForumTest() throws ParseException {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		forum.setForumName("Forum-Demo");
		forum.setUserName("bhanoosingh1");
		forum.setForumContent("Code forum");
		forum.setCreatedDate(textFormat.parse("2017-06-18"));
		assertEquals("Problem in adding forum into the table", true, forumDao.addForum(forum));
		
		System.out.println("<-----------Successfully added into forum-------->");
	}*/

	/*@Test
	public void updateForumTest() {
		
		forum.setForumId(5);
		forum.setForumName("Forum-Demo");
		forum.setUserName("bhanoosingh1");
		forum.setForumContent("This is forum content");
		assertEquals("Problem in updating status of forum", true, forumDao.updateForum(forum));
		
		System.out.println("<-----------Successfully updated into forum-------->");
	}*/
	
	/*@Test
	public void deleteForumTest() {
		
		forum.setForumId(5);
		assertEquals("Problem in deleting forum", true, forumDao.deleteForum(forum));
		
		System.out.println("<-----------Successfully deleted forum-------->");
	}*/
}
