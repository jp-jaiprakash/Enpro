package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobstype database table.
 * 
 */
@Entity
@NamedQuery(name="Jobstype.findAll", query="SELECT j FROM Jobstype j")
public class Jobstype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobid;

	private String jobdescription;

	public Jobstype() {
	}

	public int getJobid() {
		return this.jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobdescription() {
		return this.jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

}