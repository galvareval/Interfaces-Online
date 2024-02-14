/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.sql.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gianf
 */
public class BandasTest {
    
    public BandasTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getNombreBanda method, of class Bandas.
     */
    @Test
    public void testGetNombreBanda() {
        System.out.println("getNombreBanda");
        Bandas instance = null;
        String expResult = "";
        String result = instance.getNombreBanda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreBanda method, of class Bandas.
     */
    @Test
    public void testSetNombreBanda() {
        System.out.println("setNombreBanda");
        String nombreBanda = "";
        Bandas instance = null;
        instance.setNombreBanda(nombreBanda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreSala method, of class Bandas.
     */
    @Test
    public void testGetNombreSala() {
        System.out.println("getNombreSala");
        Bandas instance = null;
        String expResult = "";
        String result = instance.getNombreSala();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreSala method, of class Bandas.
     */
    @Test
    public void testSetNombreSala() {
        System.out.println("setNombreSala");
        String nombreSala = "";
        Bandas instance = null;
        instance.setNombreSala(nombreSala);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstilo method, of class Bandas.
     */
    @Test
    public void testGetEstilo() {
        System.out.println("getEstilo");
        Bandas instance = null;
        String expResult = "";
        String result = instance.getEstilo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstilo method, of class Bandas.
     */
    @Test
    public void testSetEstilo() {
        System.out.println("setEstilo");
        String estilo = "";
        Bandas instance = null;
        instance.setEstilo(estilo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaForm method, of class Bandas.
     */
    @Test
    public void testGetFechaForm() {
        System.out.println("getFechaForm");
        Bandas instance = null;
        Date expResult = null;
        Date result = instance.getFechaForm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaForm method, of class Bandas.
     */
    @Test
    public void testSetFechaForm() {
        System.out.println("setFechaForm");
        Date fechaForm = null;
        Bandas instance = null;
        instance.setFechaForm(fechaForm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCache method, of class Bandas.
     */
    @Test
    public void testGetCache() {
        System.out.println("getCache");
        Bandas instance = null;
        float expResult = 0.0F;
        float result = instance.getCache();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCache method, of class Bandas.
     */
    @Test
    public void testSetCache() {
        System.out.println("setCache");
        float cache = 0.0F;
        Bandas instance = null;
        instance.setCache(cache);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
