/**
 * 
 */
package in.jaiprakash.models;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
public class JobByStatus {
	private String jobid;
	private String clientName;
	private String lastModified;
	private String deliverydate;
	private String statusrepresent;
	private int status;
	public String getJobid() {
		return jobid;
	}
	/**
	 * 
	 */
	public JobByStatus() {
		// TODO Auto-generated constructor stub
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getStatusrepresent() {
		return statusrepresent;
	}
	public void setStatusrepresent(String statusrepresent) {
		this.statusrepresent = statusrepresent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
