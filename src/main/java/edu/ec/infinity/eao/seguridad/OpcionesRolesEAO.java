package edu.ec.infinity.eao.seguridad;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.OpcionesRoles;
import edu.ec.infinity.dominio.seguridad.OpcionesRolesPK;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.eao.generic.GenericDAOAbstract;

@Stateless
public class OpcionesRolesEAO extends GenericDAOAbstract<OpcionesRoles, OpcionesRolesPK> implements IOpcionesRolesEAO{

	@SuppressWarnings("unchecked")
	public List<Opcion> findOpcionesBy(Usuario usuario){
		
//		SELECT * 
//		  FROM segrolesusuarios ru,
//		   	   segopcionesroles opr,
//		       segusuarios u
//		 WHERE ru.cod_rol = opr.cod_rol
//		   AND u.usuario = 'eamaguaya';
		
		Query query = em.createQuery("SELECT opr.opciones "
									+ " FROM OpcionesRoles opr, "
									+ "		 RolesUsuarios ru "
								    + "WHERE opr.roles = ru.roles "
								    + "  AND ru.usuario = :user"
								    + "  	 order by opr.opciones.orden asc");
		query.setParameter("user", usuario);
		return query.getResultList();
	}
	
}