/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reyes.ejb;

import com.reyes.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "LanceroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario usuario){
        
        Usuario us = null;
        String jpql;
        try{
            jpql = "SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.contrasena = ?2"; 
            Query consulta = em.createQuery(jpql);
            consulta.setParameter(1, usuario.getUsuario());
            consulta.setParameter(2, usuario.getContrasena());

            List<Usuario> lista = consulta.getResultList();

            if (!lista.isEmpty()) {
                us = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }    
        return us;
    }
/**/    

    /**
     *
     * @param usuario
     * @return 
     */
    
    public Usuario validarUsuarioUnico(String usuario){
            return em.createNamedQuery("uniqueUser", Usuario.class)
                    .setParameter("user", usuario).getSingleResult();
    }
    
}
