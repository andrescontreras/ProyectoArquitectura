package entities;

import entities.Renta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-11T21:34:19")
@StaticMetamodel(Propiedad.class)
public class Propiedad_ { 

    public static volatile SingularAttribute<Propiedad, Character> rentada;
    public static volatile SingularAttribute<Propiedad, String> tipo;
    public static volatile SingularAttribute<Propiedad, Integer> precio;
    public static volatile SingularAttribute<Propiedad, Short> numCuartos;
    public static volatile CollectionAttribute<Propiedad, Renta> rentaCollection;
    public static volatile SingularAttribute<Propiedad, String> direccion;
    public static volatile SingularAttribute<Propiedad, String> localidad;
    public static volatile SingularAttribute<Propiedad, Short> id;
    public static volatile SingularAttribute<Propiedad, Short> idOwner;

}