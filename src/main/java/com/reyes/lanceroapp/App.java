package com.reyes.lanceroapp;

import com.reyes.model.Departamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class App {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LanceroPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Departamento dep = new Departamento();
        
        try {            
             et.begin();
             dep.setNombreDepto("La libertad");
             em.persist(dep);
             et.commit();
             System.out.println("Se guardo");
        } catch (Exception e) {
            if (et!=null) {
                et.rollback();
            }
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
