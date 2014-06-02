package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TrampaDeInsectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "trampaDeInsectos")
    private List<RegistroDeTrampaDeInsectos> registros;

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

    public List<RegistroDeTrampaDeInsectos> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDeTrampaDeInsectos> registros) {
        this.registros = registros;
    }

}
