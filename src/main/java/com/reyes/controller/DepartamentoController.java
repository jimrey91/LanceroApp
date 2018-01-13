package com.reyes.controller;

import com.reyes.ejb.DepartamentoFacade;
import com.reyes.model.Departamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Daniel
 */
@Named(value = "departamentoController")
@ViewScoped
//@RequestScoped
public class DepartamentoController implements Serializable{

    @EJB
    private DepartamentoFacade departamentoFacade;
    
    private int codigo;
    private String nombre;
    private List<Departamento> departamentos;
    
    @PostConstruct
    public void init(){
        departamentos = departamentoFacade.listarDepartamentos();
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
    
    public void guardar(){
        
        try {
            departamentoFacade.agregarDepartamento(this.nombre);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Departamento registrado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "No se registro"));
        }
    }
    
    

    /**
     * Creates a new instance of DepartamentoController
     */
    public DepartamentoController() {
    }
    
}
