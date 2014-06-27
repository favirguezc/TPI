package modelo;

import control.CustomDateFormatter;
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
    private java.util.Date fechaDeCompra;
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

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public ProductoFitosanitario getProductoFitosanitario() {
        return productoFitosanitario;
    }

    public void setProductoFitosanitario(ProductoFitosanitario productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    @Override
    public String toString() {
        return productoFitosanitario+" "+ cantidad+" " + precio +" " + new CustomDateFormatter().formatDate(fechaDeCompra);
    }
}
