package com.reyes.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "NOMBRE_PERSONA")
    private String nombre;
    
    @Column(name = "APELLIDO_PERSONA")
    private String apellido;
    
    @Column(name = "DUI_PERSONA", unique = true)
    private String dui;
    
    @Column(name = "NIT_PERSONA", unique = true)
    private String nit;
    
    @Column(name = "LICENCIA_CONDUCIR_PERSONA")
    private boolean licenciaConducir = false;
    
    @Column(name = "TELEFONO_PERSONA")
    private String telefono;
    
    @Column(name = "CELULAR_PERSONA")
    private String celular;
    
    @Column(name = "DIRECCION_PERSONA")
    private String direccion;
    
    @Column(name = "CORREO_PERSONA")
    private String correoElectronico;
    
    @Column(name = "NOMBRE_EMPRESA_PERSONA")
    private String nombreEmpresa;
    
    @Column(name = "SEXO_PERSONA")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "CODIGO_DEPA", nullable = true)
    private Departamento departamento;
    
    @Column(name = "FECHA_REGISTRO", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean isLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(boolean licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
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
        final Persona other = (Persona) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", dui=" + dui + ", nit=" + nit + ", licenciaConducir=" + licenciaConducir + ", telefono=" + telefono + ", celular=" + celular + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + ", nombreEmpresa=" + nombreEmpresa + ", sexo=" + sexo + ", departamento=" + departamento + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
    
    
    
}
