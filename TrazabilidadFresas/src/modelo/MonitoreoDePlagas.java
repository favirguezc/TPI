package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class MonitoreoDePlagas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private int numeroDePlanta;
    @OneToMany(mappedBy = "monitoreoDePlagas", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RegistroDeMonitoreoDePlagas> registros;

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

    public int getNumeroDePlanta() {
        return numeroDePlanta;
    }

    public void setNumeroDePlanta(int numeroDePlanta) {
        this.numeroDePlanta = numeroDePlanta;
    }

    public List<RegistroDeMonitoreoDePlagas> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeMonitoreoDePlagas> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        return "MonitoreoDePlagas{" + "id=" + id + ", fecha=" + fecha + ", numero_de_planta=" + numeroDePlanta + ", registros=" + registros + '}';
    }
}
