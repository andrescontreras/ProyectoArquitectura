package entities;

import entities.Propiedad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-11T21:34:19")
@StaticMetamodel(Renta.class)
public class Renta_ { 

    public static volatile SingularAttribute<Renta, Integer> precioRenta;
    public static volatile SingularAttribute<Renta, Date> fecha;
    public static volatile SingularAttribute<Renta, Propiedad> idPropiedad;
    public static volatile SingularAttribute<Renta, Short> idUsuario;
    public static volatile SingularAttribute<Renta, Short> id;
    public static volatile SingularAttribute<Renta, String> email;

}