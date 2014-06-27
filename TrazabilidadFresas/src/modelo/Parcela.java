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
public class Parcela implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String ubicacionEnLaFinca = "";
    private double area;
    private String tipoDeSuelo = "";
    private boolean activa;
    @OneToMany(mappedBy = "parcela", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Siembra> siembras;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUbicacionEnLaFinca() {
        return ubicacionEnLaFinca;
    }

    public void setUbicacionEnLaFinca(String ubicacionEnLaFinca) {
        this.ubicacionEnLaFinca = ubicacionEnLaFinca;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    public void setTipoDeSuelo(String tipo_de_suelo) {
        this.tipoDeSuelo = tipo_de_suelo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<Siembra> getSiembras() {
        return siembras;
    }

    public void setSiembras(List<Siembra> siembras) {
        this.siembras = siembras;
    }

    @Override
    public String toString() {
        return ubicacionEnLaFinca + " " + area + " " + tipoDeSuelo;
    }
}
