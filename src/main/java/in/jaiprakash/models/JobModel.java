/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import in.jaiprakash.entities.User;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class JobModel {

	private int jobautoid;

	private Date completiondate;

	private Date createddate;

	private String jobclientname;

	private Date jobdeliverydate;

	private String jobid;

	private String jobname;

	private int jobstatus;

	private Date modifieddate;

	private User user1;

	private User user2;

	public int getJobautoid() {
		return jobautoid;
	}

	public void setJobautoid(int jobautoid) {
		this.jobautoid = jobautoid;
	}

	public Date getCompletiondate() {
		return completiondate;
	}

	public void setCompletiondate(Date completiondate) {
		this.completiondate = completiondate;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getJobclientname() {
		return jobclientname;
	}

	public void setJobclientname(String jobclientname) {
		this.jobclientname = jobclientname;
	}

	public Date getJobdeliverydate() {
		return jobdeliverydate;
	}

	public void setJobdeliverydate(Date jobdeliverydate) {
		this.jobdeliverydate = jobdeliverydate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public int getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(int jobstatus) {
		this.jobstatus = jobstatus;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}
	
	
}
