package com.niit.FriendsAdda.DAO;

import java.util.List;

import com.niit.FriendsAdda.model.ApplyJob;
import com.niit.FriendsAdda.model.Job;

public interface JobDAO {

		public boolean addJob(Job job);
	    public boolean deleteJob(Job job);
	    public boolean updateJob(Job job);
	    public List<Job> listAllJobs();
	    public Job getJob(int jobId);
	    public boolean applyJob(ApplyJob applyJob);
	    public List<ApplyJob> getAllAppliedJobDetails();
}
