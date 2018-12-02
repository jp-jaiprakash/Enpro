/**
 * 
 */
package in.jaiprakash.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jaiprakash.entities.Uerrole;
import in.jaiprakash.entities.Unit;
import in.jaiprakash.models.UnitModel;
import in.jaiprakash.models.UserRolesModel;
import in.jaiprakash.repo.UnitsRepo;
import in.jaiprakash.repo.UserRolesRepo;
import in.jaiprakash.services.GeneralServices;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
@Service
public class GeneralServicesImpl implements GeneralServices {

	@Autowired
	private UserRolesRepo userRolesRepo;
	
	@Autowired
	private UnitsRepo unitsRepo;
	
	@Autowired
	private MapperFactory mapperFactory;
	/* (non-Javadoc)
	 * @see in.jaiprakash.services.GeneralServices#getUnits()
	 */
	@Override
	public List<UnitModel> getUnits() {
		// TODO Auto-generated method stub
		List<Unit> lstUnit = unitsRepo.findAll();
		List<UnitModel> lstUnitModel = new ArrayList<UnitModel>();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		lstUnitModel = mapper.mapAsList(lstUnit, UnitModel.class);
		//Use mapper as list
		//lstUnitModel = mapper.mapAsList(lstUnit, UnitModel.class);
		for(Unit u: lstUnit){
			UnitModel um = mapper.map(u, UnitModel.class);
			lstUnitModel.add(um);
		}
		return lstUnitModel;
	}

	/* (non-Javadoc)
	 * @see in.jaiprakash.services.GeneralServices#getAllRoles()
	 */
	@Override
	public List<UserRolesModel> getAllRoles() {
		// TODO Auto-generated method stub
		List<Uerrole> lstUserRole= userRolesRepo.findAll();
		List<UserRolesModel> lst = new ArrayList<>();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		for(Uerrole u: lstUserRole){
			UserRolesModel ur = mapper.map(u, UserRolesModel.class);
			lst.add(ur);
		}
		return lst;
	}

}
