package edu.ec.infinity.eao.seguridad;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.eao.generic.GenericDAOAbstract;

@Stateless
public class OpcionEAO extends GenericDAOAbstract<Opcion, Long> implements IOpcionEAO{
	
}