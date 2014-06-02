package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int maxima_valoracion;
    @OneToMany(mappedBy = "plaga")
    private List<RegistroDeMonitoreoDePlagas> registros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMaxima_valoracion() {
        return maxima_valoracion;
    }

    public void setMaxima_valoracion(int maxima_valoracion) {
        this.maxima_valoracion = maxima_valoracion;
    }

    public List<RegistroDeMonitoreoDePlagas> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeMonitoreoDePlagas> registros) {
        this.registros = registros;
    }

}
