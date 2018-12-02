package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uerroles database table.
 * 
 */
@Entity
@Table(name="uerroles")
@NamedQuery(name="Uerrole.findAll", query="SELECT u FROM Uerrole u")
public class Uerrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleid;

	private String rolevalue;

	//bi-directional many-to-one association to Usermappingtable
	@OneToMany(mappedBy="uerrole")
	private List<Usermappingtable> usermappingtables;

	public Uerrole() {
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolevalue() {
		return this.rolevalue;
	}

	public void setRolevalue(String rolevalue) {
		this.rolevalue = rolevalue;
	}

	public List<Usermappingtable> getUsermappingtables() {
		return this.usermappingtables;
	}

	public void setUsermappingtables(List<Usermappingtable> usermappingtables) {
		this.usermappingtables = usermappingtables;
	}

	public Usermappingtable addUsermappingtable(Usermappingtable usermappingtable) {
		getUsermappingtables().add(usermappingtable);
		usermappingtable.setUerrole(this);

		return usermappingtable;
	}

	public Usermappingtable removeUsermappingtable(Usermappingtable usermappingtable) {
		getUsermappingtables().remove(usermappingtable);
		usermappingtable.setUerrole(null);

		return usermappingtable;
	}

}