package com.reyes.controller;

import com.reyes.ejb.DepartamentoFacade;
import com.reyes.ejb.UsuarioFacade;
import com.reyes.model.Departamento;
import com.reyes.model.Persona;
import com.reyes.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named(value = "usuarioController")
@RequestScoped
public class UsuarioController implements Serializable{

    @EJB
    private DepartamentoFacade departamentoFacade;

    @EJB
    private UsuarioFacade usuarioFacade;
       
    private Persona persona;
    
    private Usuario usuario;
    
    private Departamento departamento;
    
    private List<Departamento> departamentos;
    
    private boolean verificarUsuarioUnico;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
        departamento = new Departamento();
        departamentos = departamentoFacade.listarDepartamentos();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
    
    public void guardar(){
        
        try {
            if(this.usuario != null){
                this.usuario.setCodigo(persona);
                this.persona.setDepartamento(departamento);
                usuarioFacade.create(this.usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario creado exitosamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario ya esta registrado"));
           }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error"));

        }
        
    }
    
    public boolean verificarUsuarioUnico(){

        try{
            usuarioFacade.validarUsuarioUnico(this.usuario.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Usuario no disponible"));
         
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario disponible"));
        }
        return true;
    }
    
    

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }
    
}
