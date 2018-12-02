package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jobs database table.
 * 
 */
@Entity
@Table(name="jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobautoid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date completiondate;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createddate;

	private String jobclientname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date jobdeliverydate;

	private String jobid;

	private String jobname;

	private int jobstatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifieddate;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="createdby", insertable= false, updatable=false)
//	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	public Job() {
	}

	public int getJobautoid() {
		return this.jobautoid;
	}

	public void setJobautoid(int jobautoid) {
		this.jobautoid = jobautoid;
	}

	public Date getCompletiondate() {
		return this.completiondate;
	}

	public void setCompletiondate(Date completiondate) {
		this.completiondate = completiondate;
	}

//	public Date getCreateddate() {
//		return this.createddate;
//	}
//
//	public void setCreateddate(Date createddate) {
//		this.createddate = createddate;
//	}

	public String getJobclientname() {
		return this.jobclientname;
	}

	public void setJobclientname(String jobclientname) {
		this.jobclientname = jobclientname;
	}

	public Date getJobdeliverydate() {
		return this.jobdeliverydate;
	}

	public void setJobdeliverydate(Date jobdeliverydate) {
		this.jobdeliverydate = jobdeliverydate;
	}

	public String getJobid() {
		return this.jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public int getJobstatus() {
		return this.jobstatus;
	}

	public void setJobstatus(int jobstatus) {
		this.jobstatus = jobstatus;
	}

	public Date getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

//	public User getUser1() {
//		return this.user1;
//	}
//
//	public void setUser1(User user1) {
//		this.user1 = user1;
//	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}