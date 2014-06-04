package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class InventarioDeProductosFitosanitarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int cantidad;
    private int precio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha_de_compra;
    @ManyToOne
    private ProductoFitosanitario productoFitosanitario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha_de_compra() {
        return fecha_de_compra;
    }

    public void setFecha_de_compra(Date fecha_de_compra) {
        this.fecha_de_compra = fecha_de_compra;
    }

    public ProductoFitosanitario getProductoFitosanitario() {
        return productoFitosanitario;
    }

    public void setProductoFitosanitario(ProductoFitosanitario productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    @Override
    public String toString() {
        return "InventarioDeProductosFitosanitarios{" + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha_de_compra=" + fecha_de_compra + ", productoFitosanitario=" + productoFitosanitario + '}';
    }
}
