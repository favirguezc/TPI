package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RegistroDeTrampaDeInsectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int fecha;
    private int especies_encontradas;
    private int numero_de_individuos;
    private boolean pegante;
    private String observaciones;
    @ManyToOne
    private TrampaDeInsectos trampaDeInsectos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getEspecies_encontradas() {
        return especies_encontradas;
    }

    public void setEspecies_encontradas(int especies_encontradas) {
        this.especies_encontradas = especies_encontradas;
    }

    public int getNumero_de_individuos() {
        return numero_de_individuos;
    }

    public void setNumero_de_individuos(int numero_de_individuos) {
        this.numero_de_individuos = numero_de_individuos;
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

}
