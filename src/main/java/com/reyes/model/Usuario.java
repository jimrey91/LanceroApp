package com.reyes.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "usuario")
@NamedQuery(name = "uniqueUser", query = "select u.usuario from Usuario u where u.usuario = :user")
public class Usuario implements Serializable {
    
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codigo", nullable = false)
    private Persona codigo;
    
    @Column(name = "USUARIO")
    private String usuario;
    
    @Column(name = "CONTRASENA")
    private String contrasena;
    
    @Column(name = "ROL")
    private String rol;
    
    @Column(name = "estado")
    private boolean estado = true;

    public Persona getCodigo() {
        return codigo;
    }

    public void setCodigo(Persona codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", usuario=" + usuario + ", contrasena=" + contrasena + ", rol=" + rol + ", estado=" + estado + '}';
    }
    
    
    
}
