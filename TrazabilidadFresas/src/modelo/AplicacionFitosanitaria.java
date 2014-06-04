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
public class AplicacionFitosanitaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fecha;
    private String motivo;
    private boolean pc;
    private boolean tr;
    private double cantidadAplicada;
    private double litrosDeAguaUtilizada;
    private double jornales;
    private String observaciones;
    @ManyToOne
    private EquipoDeAplicacionFitosanitaria equipoDeAplicacionFitosanitaria;
    @ManyToOne
    private ProductoFitosanitario productoFitosanitario;
    @ManyToOne
    private Administrador administrador;
    @ManyToOne
    private Fresicultor fresicultor;
    @ManyToOne
    private Siembra siembra;

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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public boolean isTr() {
        return tr;
    }

    public void setTr(boolean tr) {
        this.tr = tr;
    }

    public double getCantidadAplicada() {
        return cantidadAplicada;
    }

    public void setCantidadAplicada(double cantidadAplicada) {
        this.cantidadAplicada = cantidadAplicada;
    }

    public double getLitrosDeAguaUtilizada() {
        return litrosDeAguaUtilizada;
    }

    public void setLitrosDeAguaUtilizada(double litrosDeAguaUtilizada) {
        this.litrosDeAguaUtilizada = litrosDeAguaUtilizada;
    }

    public double getJornales() {
        return jornales;
    }

    public void setJornales(double jornales) {
        this.jornales = jornales;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EquipoDeAplicacionFitosanitaria getEquipoDeAplicacionFitosanitaria() {
        return equipoDeAplicacionFitosanitaria;
    }

    public void setEquipoDeAplicacionFitosanitaria(EquipoDeAplicacionFitosanitaria equipoDeAplicacionFitosanitaria) {
        this.equipoDeAplicacionFitosanitaria = equipoDeAplicacionFitosanitaria;
    }

    public ProductoFitosanitario getProductoFitosanitario() {
        return productoFitosanitario;
    }

    public void setProductoFitosanitario(ProductoFitosanitario productoFitosanitario) {
        this.productoFitosanitario = productoFitosanitario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Fresicultor getFresicultor() {
        return fresicultor;
    }

    public void setFresicultor(Fresicultor fresicultor) {
        this.fresicultor = fresicultor;
    }

    public Siembra getSiembra() {
        return siembra;
    }

    public void setSiembra(Siembra siembra) {
        this.siembra = siembra;
    }

}
