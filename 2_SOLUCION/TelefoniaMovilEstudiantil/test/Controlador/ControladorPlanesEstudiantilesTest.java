package Controlador;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.PlanPostPago;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void testNuevoEstudiante() {
        System.out.println("nuevoEstudiante");
        Cliente c = new Cliente();
        c.setNombre("Andres");
        c.setApellido("Yaguachi");
        c.setCedula("1150305843");
        c.setCiudad("Loja");
        c.setEmail("andredasdad");
        c.setNumCelular(5345345);
        List<PlanPostPago> planes = new ArrayList<>();
        AsignadorPlanes ap = new AsignadorPlanes();
        PlanPostPago p = ap.Asignar("Megas", "Basico");
        planes.add(p);
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.nuevoEstudiante(c, planes);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNuevoPlan() {
        AsignadorPlanes ap = new AsignadorPlanes();
        System.out.println("nuevoPlan");
        PlanPostPago ppp = ap.Asignar("Megas", "Basico");
        String cedula = "1150305843";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.nuevoPlan(ppp, cedula);
        
        
    }

    /**
     * Test of eliminarPlan method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testEliminarPlan() {
        System.out.println("eliminarPlan");
        String nombrePlan = "";
        String catPlan = "";
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.eliminarPlan(nombrePlan, catPlan, cedula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEstudiante method, of class
     * ControladorPlanesEstudiantiles.
     */
    @Test
    public void testEliminarEstudiante() {
        System.out.println("eliminarEstudiante");
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.eliminarEstudiante(cedula);
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
        String nombrePlanAEliminar = "";
        String categoriaPlanAEliminar = "";
        PlanPostPago nuevoPlan = null;
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.reemplazarPlan(cedula, nombrePlanAEliminar, categoriaPlanAEliminar, nuevoPlan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEstudiante method, of class
     * ControladorPlanesEstudiantiles.
     */
    @Test
    public void testActualizarEstudiante() {
        System.out.println("actualizarEstudiante");
        String cedulaParaBuscar = "";
        Cliente datosActualizados = null;
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        instance.actualizarEstudiante(cedulaParaBuscar, datosActualizados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarEstudiantes method, of class
     * ControladorPlanesEstudiantiles.
     */
    @Test
    public void testListarEstudiantes() {
        System.out.println("listarEstudiantes");
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.listarEstudiantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPlanes method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testListarPlanes() {
        System.out.println("listarPlanes");
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        List<PlanPostPago> expResult = null;
        List<PlanPostPago> result = instance.listarPlanes(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarFacturas method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testMostrarFacturas() {
        System.out.println("mostrarFacturas");
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        List<Factura> expResult = null;
        List<Factura> result = instance.mostrarFacturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarFacturaIndividual method, of class
     * ControladorPlanesEstudiantiles.
     */
    @Test
    public void testMostrarFacturaIndividual() {
        System.out.println("mostrarFacturaIndividual");
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        List<Factura> expResult = null;
        List<Factura> result = instance.mostrarFacturaIndividual(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estudiante method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testEstudiante() {
        System.out.println("estudiante");
        String cedula = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        Cliente expResult = null;
        Cliente result = instance.estudiante(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repetido method, of class ControladorPlanesEstudiantiles.
     */
    @Test
    public void testRepetido() {
        System.out.println("repetido");
        String cedula = "";
        String tipoPlan = "";
        String catPlan = "";
        ControladorPlanesEstudiantiles instance = new ControladorPlanesEstudiantiles();
        boolean expResult = false;
        boolean result = instance.repetido(cedula, tipoPlan, catPlan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
