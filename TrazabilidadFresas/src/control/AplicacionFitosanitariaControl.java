/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.AplicacionFitosanitariaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.AplicacionFitosanitaria;

/**
 *
 * @author fredy
 */
public class AplicacionFitosanitariaControl {

    AplicacionFitosanitariaDAO dao = new AplicacionFitosanitariaDAO();

    public boolean crear(AplicacionFitosanitaria f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(AplicacionFitosanitaria f) {
        return dao.delete(f.getId());
    }

    public void actualizar(AplicacionFitosanitaria f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public AplicacionFitosanitaria leer(long id) {
        return dao.read(id);
    }

    public List<AplicacionFitosanitaria> leerTodos() {
        return dao.readAll();
    }

    public List<AplicacionFitosanitaria> leerTodos(int año, int mes, int dia) {
        List<AplicacionFitosanitaria> listaDia = new ArrayList<>();
        for (AplicacionFitosanitaria a : leerTodos()) {
            if (a.getFecha().getMonth() == mes
                    && a.getFecha().getDay() == dia
                    && a.getFecha().getYear() == año) {
                listaDia.add(a);
            }
        }
        return listaDia;
    }

    private boolean validar(AplicacionFitosanitaria f) {
        if (f == null
                || f.getAdministrador() == null
                || f.getCantidadAplicada() <= 0
                || f.getEquipoDeAplicacionFitosanitaria() == null
                || f.getFecha() == null
                || f.getFecha().after(new Date())
                || f.getFresicultor() == null
                || f.getJornales() <= 0
                || f.getLitrosDeAguaUtilizada() < 0
                || f.getMotivo() == null
                || f.getMotivo().length() < 4
                || f.getProductoFitosanitario() == null
                || f.getSiembra() == null
                || f.getPc() == null
                || f.getTr() == null) {
            return false;
        }
        return true;
    }
}
