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
public class ProductoFitosanitario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String nombre = "";
    private String ingredienteActivo = "";
    @OneToMany(mappedBy = "productoFitosanitario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<InventarioDeProductosFitosanitarios> inventario;
    @OneToMany(mappedBy = "productoFitosanitario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AplicacionFitosanitaria> aplicaciones;

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

    public String getIngredienteActivo() {
        return ingredienteActivo;
    }

    public void setIngredienteActivo(String ingredienteActivo) {
        this.ingredienteActivo = ingredienteActivo;
    }

    public List<InventarioDeProductosFitosanitarios> getInventario() {
        return inventario;
    }

    public void setInventario(List<InventarioDeProductosFitosanitarios> inventario) {
        this.inventario = inventario;
    }

    public List<AplicacionFitosanitaria> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<AplicacionFitosanitaria> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
