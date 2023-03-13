package com.mycompany.exameninterfacesantoniogarcia2023;

import java.util.List;
import models.Alumno;

/**
 *
 * @author Antonio Garcia
 */
public interface AlumnoDAO {
   
    public void save( Alumno a);
    public void update( Alumno a);
    public Alumno get( Integer id);
    public void delete( Alumno a);
    public List<Alumno> getAll();
}
