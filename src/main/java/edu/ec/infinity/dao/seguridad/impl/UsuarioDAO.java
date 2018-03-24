/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dao.seguridad.impl;

import javax.ejb.Stateless;

import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioDAO;
import edu.ec.infinity.dominio.seguridad.Usuario;

/**
 *
 * @author Edwin
 */
@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long> implements IUsuarioDAO {

	public UsuarioDAO() {
		super(Usuario.class);
	}

}
