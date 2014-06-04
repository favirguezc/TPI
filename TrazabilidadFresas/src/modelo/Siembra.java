package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Siembra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @ManyToOne
    private Parcela parcela;    
    @OneToMany(mappedBy = "siembra",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AplicacionFitosanitaria> aplicaciones;
    @OneToMany(mappedBy = "siembra",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Cosecha> cosechas;

    public List<AplicacionFitosanitaria> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<AplicacionFitosanitaria> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public void setCosechas(List<Cosecha> cosechas) {
        this.cosechas = cosechas;
    }

    @Override
    public String toString() {
        return "Siembra{" + ", parcela=" + parcela + ", aplicaciones=" + aplicaciones + ", cosechas=" + cosechas + '}';
    }
}
