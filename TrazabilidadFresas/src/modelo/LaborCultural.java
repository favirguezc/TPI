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
public class LaborCultural implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "laborCultural",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RegistroDeLaborCultural> registros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<RegistroDeLaborCultural> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeLaborCultural> registros) {
        this.registros = registros;
    }

}
