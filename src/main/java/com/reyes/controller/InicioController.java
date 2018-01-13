
package com.reyes.controller;

import com.reyes.ejb.UsuarioFacade;
import com.reyes.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Daniel
 */
@Named(value = "inicioController")
@ViewScoped
public class InicioController implements Serializable{

    @EJB
    private UsuarioFacade usuarioFacade;
    
    private Usuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String validarUsuario(){
        Usuario user;
        String redireccion = null;
        try{
            user = usuarioFacade.iniciarSesion(this.usuario);
            if(user != null){
                
                redireccion ="principal?faces-redirect=true";           
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso", "Datos incorrectos"));
            }
        }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso", "Hubo un error"));
        }
        
        return redireccion;
    }
    

    /**
     * Creates a new instance of InicioController
     */
    public InicioController() {
    }
    
}
