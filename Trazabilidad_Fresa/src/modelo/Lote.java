package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @OneToMany(mappedBy = "lote")
    private List<Cosecha> cosechas;
    @OneToMany(mappedBy = "lote")
    private List<Etiqueta> etiquetas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public void setCosechas(List<Cosecha> cosechas) {
        this.cosechas = cosechas;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

}
