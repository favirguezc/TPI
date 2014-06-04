/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AplicacionFitosanitariaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    public List<AplicacionFitosanitaria> leerTodos(Date fecha) {
        List<AplicacionFitosanitaria> listaDia = new ArrayList<>();
        for (AplicacionFitosanitaria a : leerTodos()) {
            if (a.getFecha().getMonth() == fecha.getMonth()
                    && a.getFecha().getDay() == fecha.getDay()
                    && a.getFecha().getYear() == fecha.getYear()) {
                listaDia.add(a);
            }
        }
        return listaDia;
    }

    public List<AplicacionFitosanitaria> leerUltimos() {
        List<AplicacionFitosanitaria> listaSemana = new ArrayList<>();
        Calendar d = new GregorianCalendar();
        d.roll(GregorianCalendar.DAY_OF_YEAR, -7);
        for (AplicacionFitosanitaria a : leerTodos()) {
            if (a.getFecha().compareTo(d.getTime()) >= 0) {
                listaSemana.add(a);
            }
        }
        System.out.println(d.getTime());
        return listaSemana;
    }

    private boolean validar(AplicacionFitosanitaria f) {
        if (f == null) {
            System.out.println("1");
            return false;
        }
        if (f.getAdministrador() == null) {
            System.out.println("2");
            return false;
        }
        if (f.getCantidadAplicada() <= 0) {
            System.out.println("3");
            return false;
        }
        if (f.getEquipoDeAplicacionFitosanitaria() == null) {
            System.out.println("4");
            return false;
        }
        if (f.getFecha() == null) {
            System.out.println("5");
            return false;
        }
        if (f.getFecha().after(new Date())) {
            System.out.println("6");
            return false;
        }
        if (f.getFresicultor() == null) {
            System.out.println("7");
            return false;
        }
        if (f.getJornales() <= 0) {
            System.out.println("8");
            return false;
        }
        if (f.getLitrosDeAguaUtilizada() < 0) {
            System.out.println("9");
            return false;
        }
        if (f.getMotivo() == null) {
            System.out.println("10");
            return false;
        }
        if (f.getMotivo().length() < 4) {
            System.out.println("11");
            return false;
        }
        if (f.getProductoFitosanitario() == null) {
            System.out.println("12");
            return false;
        }
        if (f.getSiembra() == null) {
            System.out.println("13");
            return false;
        }
        return true;
    }
}
