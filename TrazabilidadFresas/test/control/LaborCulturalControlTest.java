/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.List;
import modelo.LaborCultural;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fredy
 */
public class LaborCulturalControlTest {
    
    public LaborCulturalControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crear method, of class LaborCulturalControl.
     */
    @Test
    public void testCrear() {
        LaborCultural f = new LaborCultural();
        f.setNombre("Aplicacion de fungicida");
        LaborCulturalControl instance = new LaborCulturalControl();
        boolean expResult = true;
        boolean result = instance.crear(f);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminar method, of class LaborCulturalControl.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        LaborCultural f = null;
        LaborCulturalControl instance = new LaborCulturalControl();
        boolean expResult = false;
        boolean result = instance.eliminar(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class LaborCulturalControl.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        LaborCultural f = null;
        LaborCulturalControl instance = new LaborCulturalControl();
        instance.actualizar(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leer method, of class LaborCulturalControl.
     */
    @Test
    public void testLeer() {
        System.out.println("leer");
        long id = 0L;
        LaborCulturalControl instance = new LaborCulturalControl();
        LaborCultural expResult = null;
        LaborCultural result = instance.leer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerTodos method, of class LaborCulturalControl.
     */
    @Test
    public void testLeerTodos() {
        System.out.println("leerTodos");
        LaborCulturalControl instance = new LaborCulturalControl();
        List<LaborCultural> expResult = null;
        List<LaborCultural> result = instance.leerTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
