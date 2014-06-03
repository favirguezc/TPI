package modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Fresicultor extends Persona {
    @OneToMany(mappedBy = "fresicultor",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AplicacionFitosanitaria> aplicaciones;
    @OneToMany(mappedBy = "fresicultor",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Cosecha> cosechas;
    @OneToMany(mappedBy = "fresicultor",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RegistroDeLaborCultural> laboresCulturales;

    public List<AplicacionFitosanitaria> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<AplicacionFitosanitaria> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public void setCosechas(List<Cosecha> cosechas) {
        this.cosechas = cosechas;
    }

    public List<RegistroDeLaborCultural> getLaboresCulturales() {
        return laboresCulturales;
    }

    public void setLaboresCulturales(List<RegistroDeLaborCultural> laboresCulturales) {
        this.laboresCulturales = laboresCulturales;
    }
    
}
