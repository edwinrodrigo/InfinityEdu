/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.eao.seguridad;

import edu.ec.infinity.dominio.seguridad.Usuarios;
import edu.ec.infinity.eao.generic.GenericDAO;
import javax.ejb.Remote;

/**
 *
 * @author Edwin
 */
@Remote
public interface IUsuarioEAO extends GenericDAO<Usuarios, Long> {
    
}