package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RegistroDeMonitoreoDePlagas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @ManyToOne
    private Plaga plaga;
    private int valoracion;
    @ManyToOne
    private MonitoreoDePlagas monitoreoDePlagas;    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Plaga getPlaga() {
        return plaga;
    }

    public void setPlaga(Plaga plaga) {
        this.plaga = plaga;
    }

    public MonitoreoDePlagas getMonitoreoDePlagas() {
        return monitoreoDePlagas;
    }

    public void setMonitoreoDePlagas(MonitoreoDePlagas monitoreoDePlagas) {
        this.monitoreoDePlagas = monitoreoDePlagas;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

}
