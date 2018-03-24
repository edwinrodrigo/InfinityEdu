/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dao.seguridad;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.seguridad.Usuario;

import javax.ejb.Remote;

/**
 *
 * @author Edwin
 */
@Remote
public interface IUsuarioDAO extends IGenericDAO<Usuario, Long> {
    
}