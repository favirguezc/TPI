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
public class RegistroDeTrampaDeInsectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private int especieEncontrada;
    private int numeroDeIndividuos;
    private boolean pegante;
    private String observaciones="";
    @ManyToOne
    private TrampaDeInsectos trampaDeInsectos;

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

    public int getEspeciesEncontradas() {
        return especieEncontrada;
    }

    public void setEspeciesEncontradas(int especiesEncontradas) {
        this.especieEncontrada = especiesEncontradas;
    }

    public int getNumeroDeIndividuos() {
        return numeroDeIndividuos;
    }

    public void setNumeroDeIndividuos(int numeroDeIndividuos) {
        this.numeroDeIndividuos = numeroDeIndividuos;
    }

    public boolean isPegante() {
        return pegante;
    }

    public void setPegante(boolean pegante) {
        this.pegante = pegante;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TrampaDeInsectos getTrampaDeInsectos() {
        return trampaDeInsectos;
    }

    public void setTrampaDeInsectos(TrampaDeInsectos trampaDeInsectos) {
        this.trampaDeInsectos = trampaDeInsectos;
    }

    @Override
    public String toString() {
        return "RegistroDeTrampaDeInsectos{" + ", fecha=" + fecha + ", especies_encontradas=" + especieEncontrada + ", numero_de_individuos=" + numeroDeIndividuos + ", pegante=" + pegante + ", observaciones=" + observaciones + ", trampaDeInsectos=" + trampaDeInsectos + '}';
    }
}
