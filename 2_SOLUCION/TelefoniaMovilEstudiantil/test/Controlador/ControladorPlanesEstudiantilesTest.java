/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.PlanPostPago;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class ControladorPlanesEstudiantilesTest {
    
    public ControladorPlanesEstudiantilesTest() {
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
     * Test of nuevoEstudiante method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testNuevoEstudiante() {
        System.out.println("nuevoEstudiante");
        Cliente c = null;
        List<PlanPostPago> planes = null;
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.nuevoEstudiante(c, planes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoPlan method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testNuevoPlan() {
        System.out.println("nuevoPlan");
        PlanPostPago ppp = null;
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.nuevoPlan(ppp, cedula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPlan method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testEliminarPlan() {
        System.out.println("eliminarPlan");
        String nombrePlan = "";
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.eliminarPlan(nombrePlan, cedula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reemplazarPlan method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testReemplazarPlan() {
        System.out.println("reemplazarPlan");
        String cedula = "";
        String nomPElim = "";
        PlanPostPago ppp = null;
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.reemplazarPlan(cedula, nomPElim, ppp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarEstudiantes method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testMostrarEstudiantes() {
        System.out.println("mostrarEstudiantes");
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.mostrarEstudiantes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPlanesdEstudiante method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testMostrarPlanesdEstudiante() {
        System.out.println("mostrarPlanesdEstudiante");
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.mostrarPlanesdEstudiante();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEstudiante method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testActualizarEstudiante() {
        System.out.println("actualizarEstudiante");
        String cedula = "";
        Cliente c = null;
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.actualizarEstudiante(cedula, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarFactura method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testMostrarFactura() {
        System.out.println("mostrarFactura");
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.mostrarFactura();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
