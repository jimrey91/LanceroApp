package com.reyes.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "departamento")
@NamedQuery(name = "findAll", query = "SELECT d FROM Departamento d")
public class Departamento implements Serializable{
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_DEPA")
    private int codigoDepto;
    
    @Column(name = "NOMBRE_DEPA")
    private String nombreDepto;

    public int getCodigoDepto() {
        return codigoDepto;
    }

    public void setCodigoDepto(int codigoDepto) {
        this.codigoDepto = codigoDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigoDepto;
        hash = 89 * hash + Objects.hashCode(this.nombreDepto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (this.codigoDepto != other.codigoDepto) {
            return false;
        }
        if (!Objects.equals(this.nombreDepto, other.nombreDepto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigoDepto=" + codigoDepto + ", nombreDepto=" + nombreDepto + '}';
    }
    
}
