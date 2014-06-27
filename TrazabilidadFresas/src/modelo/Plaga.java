package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Plaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String nombre = "";
    private int maximaValoracion;
    @OneToMany(mappedBy = "plaga", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RegistroDeMonitoreoDePlagas> registros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMaximaValoracion() {
        return maximaValoracion;
    }

    public void setMaximaValoracion(int maxima_valoracion) {
        this.maximaValoracion = maxima_valoracion;
    }

    public List<RegistroDeMonitoreoDePlagas> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeMonitoreoDePlagas> registros) {
        this.registros = registros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
