/**
 * 
 */
package in.jaiprakash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import in.jaiprakash.entities.Material;
import in.jaiprakash.models.MaterialModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface MaterialRepo extends GenericRepository<Material, Integer> {

	@Query(value="select em.materialid, em.materialname from enprosyst.materials em where em.materialname is not null" , nativeQuery=true)
	List<Object[]> fetchMaterialNamesNValues();
	
	List<Material> findBymaterialname(String materialname);
	
	@Query(value="select em.materialid, em.materialname, em.total, em.reserved, em.available, eu.unitvalue from enprosyst.materials em inner join enprosyst.units eu on eu.unitid = em.unit" , nativeQuery=true)
	List<Object []> fetchMaterialsWithQuantity();
}
