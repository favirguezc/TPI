package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cosecha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int tipo;
    private double cantidad;
    @ManyToOne
    private Lote lote;
    @ManyToOne
    private Fresicultor fresicultor;
    @ManyToOne
    private Siembra siembra;
    @ManyToOne
    private Fresa fresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Fresicultor getFresicultor() {
        return fresicultor;
    }

    public void setFresicultor(Fresicultor fresicultor) {
        this.fresicultor = fresicultor;
    }

    public Siembra getSiembra() {
        return siembra;
    }

    public void setSiembra(Siembra siembra) {
        this.siembra = siembra;
    }

    public Fresa getFresa() {
        return fresa;
    }

    public void setFresa(Fresa fresa) {
        this.fresa = fresa;
    }

}
