/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gianf
 */
public class ConexionesBBDDTest {
    
    public ConexionesBBDDTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getConnection method, of class ConexionesBBDD.
     * Comprobar la conexion con la base de datos
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = ConexionesBBDD.getConnection();//comporbar que la conexion no sea nula
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of loginUsuario method, of class ConexionesBBDD.Comprbar si el usuario hace login con la psw
     */
    @Test
    public void testLoginUsuario() {
        System.out.println("Test loginUsuario");
        String usuarioLogin = "gian";
        String pswLogin = "gian";
        boolean expResult = true;//Este registro de login esta en el script de creacion de la BBDD
        boolean result = ConexionesBBDD.loginUsuario(usuarioLogin, pswLogin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of nombresBandas method, of class ConexionesBBDD.
     */
    @Test
    public void testNombresBandas() {
        System.out.println("nombresBandas");
        ArrayList<String> expResult = null;
        ArrayList<String> result = ConexionesBBDD.nombresBandas();
        //Añadir los nombres de las bandas que se crean por defecto con el scrip de la BBDD: HARDGZ y ESTOPA
        //Al hacer el test sin modificar nada el resultado sera ok
        expResult.add("hardgz");
        expResult.add("estopa");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
