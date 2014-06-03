package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class RegistroDeLaborCultural implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha;
    private String observaciones;
    private double jornales;
    @ManyToOne
    private Fresicultor fresicultor;
    @ManyToOne
    private LaborCultural laborCultural;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getJornales() {
        return jornales;
    }

    public void setJornales(double jornales) {
        this.jornales = jornales;
    }
    
    public Fresicultor getFresicultor() {
        return fresicultor;
    }

    public void setFresicultor(Fresicultor fresicultor) {
        this.fresicultor = fresicultor;
    }

    public LaborCultural getLaborCultural() {
        return laborCultural;
    }

    public void setLaborCultural(LaborCultural laborCultural) {
        this.laborCultural = laborCultural;
    }

}
