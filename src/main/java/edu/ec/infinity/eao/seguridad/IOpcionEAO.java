package edu.ec.infinity.eao.seguridad;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.eao.generic.GenericDAO;

@Remote
public interface IOpcionEAO extends GenericDAO<Opcion, Long>{

}