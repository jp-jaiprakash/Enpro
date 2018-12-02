package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the units database table.
 * 
 */
@Entity
@Table(name="units")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int unitid;

	private String unitvalue;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="unitBean")
	private List<Material> materials;

	public Unit() {
	}

	/**
	 * @param unitid
	 */
	public Unit(int unitid) {
		super();
		this.unitid = unitid;
	}

	public int getUnitid() {
		return this.unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public String getUnitvalue() {
		return this.unitvalue;
	}

	public void setUnitvalue(String unitvalue) {
		this.unitvalue = unitvalue;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setUnitBean(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setUnitBean(null);

		return material;
	}

}