package com.reyes.ejb;

import com.reyes.model.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel
 */
@Stateless
public class DepartamentoFacade {
    
    @PersistenceContext(unitName = "LanceroPU")   
    protected EntityManager em;
    
    EntityManager getEntiyManager(){
        return em;
    }

    public Departamento agregarDepartamento(String nombre) {
        Departamento departamento = new Departamento();
        departamento.setNombreDepto(nombre);
        getEntiyManager().persist(departamento);
        return departamento;
    }
    
    public List<Departamento> listarDepartamentos(){
        TypedQuery query = getEntiyManager().createNamedQuery("findAll", Departamento.class);
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
