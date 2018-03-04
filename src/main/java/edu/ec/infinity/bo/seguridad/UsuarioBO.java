/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.bo.seguridad;

import edu.ec.infinity.dominio.seguridad.Usuarios;
import edu.ec.infinity.eao.seguridad.IUsuarioEAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Edwin
 */

@Stateless
public class UsuarioBO {
    
    @EJB
    private IUsuarioEAO usuarioEAO;
    
    public void guardar(Usuarios usuario){
        usuarioEAO.create(usuario);
    }
    
    public Usuarios merge(Usuarios usuario){
        return usuarioEAO.edit(usuario);
    }
}