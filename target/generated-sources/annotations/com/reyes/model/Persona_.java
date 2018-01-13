package com.reyes.model;

import com.reyes.model.Departamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T18:33:25")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Integer> codigo;
    public static volatile SingularAttribute<Persona, Boolean> licenciaConducir;
    public static volatile SingularAttribute<Persona, Date> fechaRegistro;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> nombreEmpresa;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> nit;
    public static volatile SingularAttribute<Persona, String> dui;
    public static volatile SingularAttribute<Persona, String> celular;
    public static volatile SingularAttribute<Persona, Departamento> departamento;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> sexo;
    public static volatile SingularAttribute<Persona, String> correoElectronico;

}