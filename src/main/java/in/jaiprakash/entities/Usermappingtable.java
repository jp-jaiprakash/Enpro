package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usermappingtable database table.
 * 
 */
@Entity
@NamedQuery(name="Usermappingtable.findAll", query="SELECT u FROM Usermappingtable u")
public class Usermappingtable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usermapid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	//bi-directional many-to-one association to Uerrole
	@ManyToOne
	@JoinColumn(name="userrole", insertable= false, updatable=false)
	private Uerrole uerrole;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby", insertable= false, updatable=false)
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid", insertable= false, updatable=false)
	private User user2;

	public Usermappingtable() {
	}

	public int getUsermapid() {
		return this.usermapid;
	}

	public void setUsermapid(int usermapid) {
		this.usermapid = usermapid;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Uerrole getUerrole() {
		return this.uerrole;
	}

	public void setUerrole(Uerrole uerrole) {
		this.uerrole = uerrole;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}