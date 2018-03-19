package edu.ec.infinity.eao.seguridad;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.RolesUsuarios;
import edu.ec.infinity.dominio.seguridad.RolesUsuariosPK;
import edu.ec.infinity.eao.generic.GenericDAOAbstract;

@Stateless
public class RolesUsuariosEAO extends GenericDAOAbstract<RolesUsuarios, RolesUsuariosPK> implements IRolesUsuariosEAO{

}
