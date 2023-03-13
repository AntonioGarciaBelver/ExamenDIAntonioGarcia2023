package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

/**
 *
 * @author Antonio
 */
@Entity
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private Double AD;
    private Double SGE;
    private Double DI;
    private Double PMDM;
    private Double EIE;
    private Double HLC;
    private Double PSP;

    public Double getPSP() {
        return PSP;
    }

    public void setPSP(Double PSP) {
        this.PSP = PSP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getAD() {
        return AD;
    }

    public void setAD(Double AD) {
        this.AD = AD;
    }

    public Double getSGE() {
        return SGE;
    }

    public void setSGE(Double SGE) {
        this.SGE = SGE;
    }

    public Double getDI() {
        return DI;
    }

    public void setDI(Double DI) {
        this.DI = DI;
    }

    public Double getPMDM() {
        return PMDM;
    }

    public void setPMDM(Double PMDM) {
        this.PMDM = PMDM;
    }

    public Double getEIE() {
        return EIE;
    }

    public void setEIE(Double EIE) {
        this.EIE = EIE;
    }

    public Double getHLC() {
        return HLC;
    }

    public void setHLC(Double HLC) {
        this.HLC = HLC;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", AD=" + AD + ", SGE=" + SGE + ", DI=" + DI + ", PMDM=" + PMDM + ", EIE=" + EIE + ", HLC=" + HLC + '}';
    }
    
}

