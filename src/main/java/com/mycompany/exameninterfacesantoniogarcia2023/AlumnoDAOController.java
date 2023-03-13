
package com.mycompany.exameninterfacesantoniogarcia2023;


import models.Alumno;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Transaction;



/**
 *
 * @author anton
 */
public class AlumnoDAOController implements AlumnoDAO {

    @Override
    public void save(Alumno a) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.save(a);
            t.commit();
        }
    }

    @Override
    public void update(Alumno a) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.update(a);
            t.commit();
        }
    }

    @Override
    public Alumno get(Integer id) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            return s.get(Alumno.class,id);     
        }
    }

    @Override
    public void delete(Alumno a) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.delete(a);
            t.commit();
        }
    }

    @Override
    public List<Alumno> getAll() {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            var q = s.createQuery("from Alumno");
            return q.list();
        }
    }
    
}

