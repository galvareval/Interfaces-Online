/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author gianf
 */
public class ConexionesBBDD {

    private static String url = "jdbc:mysql://localhost:3306/managerBandas";
    private static String user = "root";
    private static String password = "root";

    /**
     * Conectar con la BBDD 
     *
     * @return Obj de la conexión
     */
    public static Connection getConnection() {
        Connection connection = null;
        //ESCRIBE AQUI TU CODIGO
        //INICIO
        //Establece una conexión con la base de datos utilizando las variables estáticas "url", "user" y "password"
        //Si ocurre cualquier otro error durante la ejecución, muestra el mensaje en el log de la aplicación
        //establecer la coexion con la base de datos de Mysql
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("No se ha podido conectar" + e.getMessage());
        }
        //FIN
        return connection;
    }
    /**
     * Verficar las credenciales de un usuario que quiera hacer login
     * @param usuarioLogin
     * @param pswLogin
     * @return 
     */
    public static boolean loginUsuario(String usuarioLogin, String pswLogin) {
        boolean loginOk = false;
        try {
            Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement("SELECT  nombre, psw FROM usuarios WHERE nombre LIKE '" + usuarioLogin + "'" + " AND psw LIKE '" + pswLogin + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                loginOk = true;
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "", JOptionPane.ERROR_MESSAGE);
            }
            con.close(); // Cerrar conexión

        } catch (SQLException ex) {
            Logger.getLogger(ConexionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loginOk;
    }
    /**
     * Insertar un regitro de nuevo usuario en la BBDD
     * @param usuario
     * @param psw
     * @return 
     */
    public static boolean addUsuario(String usuario, String psw) {
        boolean usuarioAddOk = false;
        Pattern usuarioMask = Pattern.compile("[a-zA-Z0-9]{1,8}");
        Matcher validarUsuario = usuarioMask.matcher(usuario);
        Matcher validadPsw = usuarioMask.matcher(psw);
        if (validarUsuario.matches() && validadPsw.matches()) {
            try {
                int exiteUsuario = 0;
                Connection con = getConnection();
                //comprobar si ya existe el usuario
                Statement sentenciaUsuarioExiste = con.createStatement();
                //String para la consulta SQL 
                String sqlExisteUsuario = "SELECT COUNT(nombre) FROM usuarios WHERE nombre LIKE '" + usuario + "'";
                //Resulset de la ejecución de la consulta 
                ResultSet usuarioResultSetExiste = sentenciaUsuarioExiste.executeQuery(sqlExisteUsuario);

                while (usuarioResultSetExiste.next()) {
                    exiteUsuario = usuarioResultSetExiste.getInt(1);//La consulta devuelve un resgitro
                }

                //ADD si no existe el usuario
                if (exiteUsuario != 1) {
                    String sqlInsert = ("INSERT INTO usuarios VALUES (?,?)");
                    //Preparedstatement para el insert
                    PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
                    //cargar la sentencia con los parámetros
                    pstmtInsert.setString(1, usuario);
                    pstmtInsert.setString(2, psw);
                    pstmtInsert.executeUpdate();
                    pstmtInsert.close();
                    con.close();
                    usuarioAddOk = true;
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe", "", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario y contraseña tienen que ser de 8 caracteres", "", JOptionPane.ERROR_MESSAGE);
        }
        return usuarioAddOk;
    }
    /**
     * Insertar un registro de una nueva sala en la BBDD
     * @param nombreSala
     * @param aforo
     * @param precio
     * @param localidad
     * @return 
     */
    public static boolean addSala(String nombreSala, String aforo, String precio, String localidad) {
        boolean addSalaok = false;
        Pattern nombreSalaMask = Pattern.compile("[a-zA-Z]{1,20}");
        Pattern aforoMask = Pattern.compile("[0-9]{1,30}");
        Pattern precioMask = Pattern.compile("[0-9]{1,10}\\.{0,1}[0-9]{0,2}");
        Pattern localidadMask = Pattern.compile("[a-zA-Z]{1,20}");

        Matcher validarMatcherNombreSala = nombreSalaMask.matcher(nombreSala);
        Matcher validarMatcherAforo = aforoMask.matcher(aforo);
        Matcher validarMatcherPrecio = precioMask.matcher(precio);
        Matcher validarMatcherLocalidad = localidadMask.matcher(localidad);

        if (validarMatcherNombreSala.matches()) {
            if (validarMatcherAforo.matches()) {
                if (validarMatcherPrecio.matches()) {
                    if (validarMatcherLocalidad.matches()) {
                        //insertar si no existe
                        try {
                            int exiteSala = 0;
                            Connection con = getConnection();
                            //comprobar si ya existe la sala
                            Statement sentenciaSalaExiste = con.createStatement();
                            //String para la consulta SQL 
                            String sqlExisteSala = "SELECT COUNT(nombre_sala) FROM salas WHERE nombre_sala LIKE '" + nombreSala + "'";
                            //Resulset de la ejecución de la consulta 
                            ResultSet salaResultSetExiste = sentenciaSalaExiste.executeQuery(sqlExisteSala);

                            while (salaResultSetExiste.next()) {
                                exiteSala = salaResultSetExiste.getInt(1);//La consulta devuelve un resgitro
                            }

                            //ADD si no existe la sala
                            if (exiteSala != 1) {
                                String sqlInsert = ("INSERT INTO salas VALUES (?,?,?,?)");
                                //Preparedstatement para el insert
                                PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
                                //cargar la sentencia con los parámetros
                                pstmtInsert.setString(1, nombreSala);
                                pstmtInsert.setString(2, aforo);
                                pstmtInsert.setString(3, precio);
                                pstmtInsert.setString(4, localidad);
                                pstmtInsert.executeUpdate();
                                pstmtInsert.close();
                                con.close();
                                addSalaok = true;
                                JOptionPane.showMessageDialog(null, "Sala registrada correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "La sala ya existe", "", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ConexionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La localidad es de máximo 20 caracteres", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero con dos decimales", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El aforo tiene que ser un numero", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la sala es de máximo 30 caracteres", "", JOptionPane.ERROR_MESSAGE);
        }

        return addSalaok;
    }
    /**
     * Injsertar un registro de nueva banda en la BBDD
     * @param nombreBanda
     * @param nombreSala
     * @param estilo
     * @param fechaForm
     * @param cache
     * @return 
     */
    public static boolean addBanda(String nombreBanda, String nombreSala, String estilo, String fechaForm, String cache) {
        boolean addBandaOk = false;
        Pattern nombreBandaMask = Pattern.compile("[a-zA-Z]{1,30}");
        Pattern estiloMask = Pattern.compile("[a-zA-Z]{1,20}");
        Pattern cacheMask = Pattern.compile("[0-9]{1,10}\\.{0,1}[0-9]{0,2}");
        
        Matcher validarMatcherNombreBanda = nombreBandaMask.matcher(nombreBanda);
        Matcher validarMatcherEstilo = estiloMask.matcher(estilo);
        Matcher validarMatcherPrecio = cacheMask.matcher(cache);
        
        if (validarMatcherNombreBanda.matches()) {
                if (validarMatcherEstilo.matches()) {
                    if (validarMatcherPrecio.matches()) {
                        //insertar si no existe
                        try {
                            int exiteBanda = 0;
                            Connection con = getConnection();
                            //comprobar si ya existe la banda
                            Statement sentenciaSBandaExiste = con.createStatement();
                            //String para la consulta SQL 
                            String sqlExisteBanda = "SELECT COUNT(nombre_banda) FROM bandas WHERE nombre_banda LIKE '" + nombreBanda + "'";
                            //Resulset de la ejecución de la consulta 
                            ResultSet bandaResultSetExiste = sentenciaSBandaExiste.executeQuery(sqlExisteBanda);

                            while (bandaResultSetExiste.next()) {
                                exiteBanda = bandaResultSetExiste.getInt(1);//La consulta devuelve un resgitro
                            }

                            //ADD si no existe la sala
                            if (exiteBanda != 1) {
                                String sqlInsert = ("INSERT INTO bandas VALUES (?,?,?,?,?)");
                                //Preparedstatement para el insert
                                PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
                                //cargar la sentencia con los parámetros
                                pstmtInsert.setString(1, nombreBanda);
                                pstmtInsert.setString(2, nombreSala);
                                pstmtInsert.setString(3, estilo);
                                pstmtInsert.setString(4, fechaForm);
                                pstmtInsert.setString(5, cache);                              
                                pstmtInsert.executeUpdate();
                                pstmtInsert.close();
                                con.close();
                                addBandaOk = true;
                                JOptionPane.showMessageDialog(null, "Banda registrada correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "La banda ya existe", "", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ConexionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El precio tiene como máximo 2 decimales", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El erstilo tiene maximo 20 caracteres", "", JOptionPane.ERROR_MESSAGE);
                }
            
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la sala es de máximo 30 caracteres", "", JOptionPane.ERROR_MESSAGE);
        }

        return addBandaOk;
    }
    /**
     * Añadir nuevo registro de un miembro a la BBDD
     * @param dni
     * @param nombreBanda
     * @param dir
     * @param edad
     * @param instrumento
     * @return 
     */
    public static boolean addMiembro(String dni, String nombreBanda, String dir, String edad, String instrumento)
    {
        boolean addMiembroOk = false;
        
        Pattern dniMask = Pattern.compile("[0-9]{7,8}[a-zA-Z]");
        Pattern dirMask = Pattern.compile("[a-zA-Z]{1,30}");
        Pattern edadMask = Pattern.compile("[0-9]{1,3}");
        Pattern instrumentoMask = Pattern.compile("[a-zA-Z]{1,20}");
        
        Matcher validarMatcherDni = dniMask.matcher(dni);
        Matcher validarMatcherDir = dirMask.matcher(dir);
        Matcher validarMatcherEdad = edadMask.matcher(edad);
        Matcher validarMatcherInstrumento = instrumentoMask.matcher(instrumento);
        
        if (validarMatcherDni.matches()) {
            if (validarMatcherDir.matches()) {
                if (validarMatcherEdad.matches()) {
                    if (validarMatcherInstrumento.matches()) {
                        //insertar si no existe
                        try {
                            int exiteMiembro = 0;
                            Connection con = getConnection();
                            //comprobar si ya existe el miembro
                            Statement sentenciaMiembroExiste = con.createStatement();
                            //String para la consulta SQL 
                            String sqlExisteMiembro = "SELECT COUNT(dni) FROM miembros WHERE dni LIKE '" + dni + "' && nombre_banda LIKE '" + nombreBanda + "'";
                            //Resulset de la ejecución de la consulta 
                            ResultSet miembroResultSetExiste = sentenciaMiembroExiste.executeQuery(sqlExisteMiembro);

                            while (miembroResultSetExiste.next()) {
                                exiteMiembro = miembroResultSetExiste.getInt(1);//La consulta devuelve un resgitro
                            }

                            //ADD si no existe la sala
                            if (exiteMiembro != 1) {
                                String sqlInsert = ("INSERT INTO miembros VALUES (?,?,?,?,?)");
                                //Preparedstatement para el insert
                                PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
                                //cargar la sentencia con los parámetros
                                pstmtInsert.setString(1, dni);
                                pstmtInsert.setString(2, nombreBanda);
                                pstmtInsert.setString(3, dir);
                                pstmtInsert.setString(4, edad);
                                pstmtInsert.setString(5, instrumento);
                                pstmtInsert.executeUpdate();
                                pstmtInsert.close();
                                con.close();
                                addMiembroOk = true;
                                JOptionPane.showMessageDialog(null, "Miembro registrado correctamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "El miembro ya existe", "", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ConexionesBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre del instrumento es de máximo 20 caracteres", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La edad tiene que ser un número", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dirección máxima 30 caracteres", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El DNI tiene que ser de 8 caracteres y una letra", "", JOptionPane.ERROR_MESSAGE);
        }
        
        return addMiembroOk;
    }
    /**
     * Obtener los nomres de las salas registradas
     * @return 
     */
    public static  ArrayList<String> nombresSalas()
    {
        ArrayList<String> nombresSalas = new ArrayList<String>();
        
        try {
            Connection con = getConnection();
            
            //Statement para la consulta
            Statement sentenciaNombresSalas = con.createStatement();
            //String para la consulta SQL que se ejecutará en la base de datos y con la que se obtendrán los nomrbes de las salas
            String sqlBuscarnombresSalas = "SELECT nombre_sala FROM salas ORDER BY nombre_sala ASC";
            //Resulset de la ejecución de la consulta 
            ResultSet nombresSalasResultSet = sentenciaNombresSalas.executeQuery(sqlBuscarnombresSalas);
            //Recorrer el resulset para llenar el array
            while (nombresSalasResultSet.next()) 
            {
                nombresSalas.add(nombresSalasResultSet.getString(1));
            }
            nombresSalasResultSet.close(); // Cerrar ResultSet
            sentenciaNombresSalas.close(); // Cerrar Statement
            con.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
        return nombresSalas;
    }
    /**
     * Obtrener los nombres las bandas registradas
     * @return 
     */
    public static  ArrayList<String> nombresBandas()
    {
        ArrayList<String> nombreBandas = new ArrayList<String>();
        
        try {
            Connection con = getConnection();
            
            //Statement para la consulta
            Statement sentenciaNombresBandas = con.createStatement();
            //String para la consulta SQL que se ejecutará en la base de datos y con la que se obtendrán los nomrbes de las salas
            String sqlBuscarnombresBandas = "SELECT nombre_banda FROM bandas ORDER BY nombre_banda ASC";
            //Resulset de la ejecución de la consulta 
            ResultSet nombresBandasResultSet = sentenciaNombresBandas.executeQuery(sqlBuscarnombresBandas);
            //Recorrer el resulset para llenar el array
            while (nombresBandasResultSet.next()) 
            {
                nombreBandas.add(nombresBandasResultSet.getString(1));
            }
            nombresBandasResultSet.close(); // Cerrar ResultSet
            sentenciaNombresBandas.close(); // Cerrar Statement
            con.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
        return nombreBandas;
    }
    /**
     * Obtener los resgistros de todas las salas de al bbdd
     * @return 
     */
    public static ArrayList<Salas> obtenerSalas()
    {
        ArrayList<Salas> salas = new ArrayList<Salas>();
        try {
            Connection con = getConnection();
            Salas salasTmp = null;
            //Statement para la consulta
            Statement sentenciaSalas = con.createStatement();
            //String para la consulta SQL que se ejecutará en la base de datos y con la que se obtendrán los nomrbes de las salas
            String sqlDatosSalas = "SELECT * FROM salas ORDER BY nombre_sala ASC";
            //Resulset de la ejecución de la consulta 
            ResultSet datosSalasResultSet = sentenciaSalas.executeQuery(sqlDatosSalas);
            //Recorrer el resulset para llenar el array
            while (datosSalasResultSet.next()) 
            {
                String nombreSala = datosSalasResultSet.getString(1);
                String aforo = datosSalasResultSet.getString(2);
                String precio = datosSalasResultSet.getString(3);
                String localidad = datosSalasResultSet.getString(4);
                //Crear un objeto salas temporal para llenarlo con los datos de la fila
                salasTmp = new Salas(nombreSala,Integer.valueOf(aforo),Float.valueOf(precio),localidad);
                //añadir el objeto vuelo con los datos de la fila al arraylist de vuelos
                salas.add(salasTmp);
            }
            datosSalasResultSet.close(); // Cerrar ResultSet
            sentenciaSalas.close(); // Cerrar Statement
            con.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
        return salas;
    }
}
