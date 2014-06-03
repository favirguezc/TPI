package modelo;

import java.io.Serializable;
import java.util.List;
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
    private String ubicacion_en_la_finca;
    private double area;
    private String tipo_de_suelo;
    private boolean activa;
    @OneToMany(mappedBy = "parcela", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Siembra> siembras;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUbicacion_en_la_finca() {
        return ubicacion_en_la_finca;
    }

    public void setUbicacion_en_la_finca(String ubicacion_en_la_finca) {
        this.ubicacion_en_la_finca = ubicacion_en_la_finca;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTipo_de_suelo() {
        return tipo_de_suelo;
    }

    public void setTipo_de_suelo(String tipo_de_suelo) {
        this.tipo_de_suelo = tipo_de_suelo;
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

}
