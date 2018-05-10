package com.niit.FriendsAdda.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.FriendsAdda.DAO.JobDAO;
import com.niit.FriendsAdda.model.Job;

public class JobDAOTest {

	static Job job;
	static JobDAO jobDao;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		job =new Job();
		jobDao = (JobDAO) context.getBean("jobDAO");
	} 
	
	/*@Test
	public void addJobTest() throws ParseException {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		job.setJobTitle("Java Developer");
		job.setJobDescription("Should have frameworks knowledge");
		job.setSalary("150000");
		job.setPostedDate(textFormat.parse("2017-06-18"));
		assertEquals("Problem in adding job into the table", true, jobDao.addJob(job));
		
		System.out.println("<-----------Successfully added into job-------->");
	}*/

	/*@Test
	public void updateForumTest()throws ParseException {
		
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		job.setJobId(6);
		job.setJobTitle("Java Developer");
		job.setJobDescription("Should have frameworks knowledge");
		job.setSalary("150000");
		job.setDesgination("Java Developer");
		job.setPostedDate(textFormat.parse("2017-06-18"));
		assertEquals("Problem in updating status of forum", true, jobDao.updateJob(job));
		
		System.out.println("<-----------Successfully updated into forum-------->");
	}*/
	
	/*@Test
	public void deleteForumTest() {
		
		job.setJobId(6);
		assertEquals("Problem in deleting job", true, jobDao.deleteJob(job));
		
		System.out.println("<-----------Successfully deleted job-------->");
	}*/
}
