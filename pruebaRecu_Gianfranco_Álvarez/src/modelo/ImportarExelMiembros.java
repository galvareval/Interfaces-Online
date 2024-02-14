/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Row;

public class ImportarExelMiembros 
{
    public static ArrayList<String[]> leerDatosDeExel(File miembrosEnExel)
    {    
        ArrayList<String[]> arrayDatos = new ArrayList<>();
        InputStream excelStream = null;
        try {
            
            //archivo exel
            excelStream = new FileInputStream(miembrosEnExel);
            System.out.println("El archivoo  " + miembrosEnExel.getName());
            // Representación del más alto nivel de la hoja excel.
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
            System.out.println("petaaaaaaaaaaquiiiiiiiiii");
            // Elegimos la hoja que se pasa por parámetro.
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);    
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            HSSFRow hssfRow = hssfSheet.getRow(hssfSheet.getTopRow());
            String [] datos = new String[hssfRow.getLastCellNum()];            
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (Row row: hssfSheet) {                    
                
                arrayDatos.add(datos); 
                datos = new String[hssfRow.getLastCellNum()];  
            }            
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("No se encontró el fichero " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error al procesar el fichero " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error al procesar el fichero después de cerrarlo " + ex);
            }
        }
        return arrayDatos;
    }
/*
    public static ArrayList<Miembros> validaRdatosLeidos(ArrayList<String[]> datosExel)
    {
        ArrayList<Miembros> mimbrosAinsertar = new ArrayList<Miembros>();
        String resultadoValidacion = "Resultado de la validación";
        int r = 0;

        Pattern dniMask = Pattern.compile("[0-9]{7,8}[a-zA-Z]");
        Pattern dirMask = Pattern.compile("[a-zA-Z]{1,30}");
        Pattern edadMask = Pattern.compile("[0-9]{1,3}");
        Pattern instrumentoMask = Pattern.compile("[a-zA-Z]{1,20}");
        
        Matcher validarMatcherDni = dniMask.matcher(dni);
        Matcher validarMatcherDir = dirMask.matcher(dir);
        Matcher validarMatcherEdad = edadMask.matcher(edad);
        Matcher validarMatcherInstrumento = instrumentoMask.matcher(instrumento);
        for (String[] next : datosExel) 
        {
            //Fila---r--System.out.print("Array Row: " + r++ + " -> ");
            //array de 5 [DNI, nombre_banda,dir,edad,instrumento]
            System.out.println("Datos de la fila" + r++);

            for (int c = 0; c < next.length; c++) //Datos de la columna(next)
            {
                System.out.print("[Column " + c + ": " + next + "] ");
            }
            System.out.println();
        }
        return mimbrosAinsertar;

    }
*/
    public static ArrayList<Miembros> miembrosAinsertarDeExel(File miembrosEnExel)
    {
        ArrayList<String[]> datosExel = new ArrayList<>();
        datosExel = leerDatosDeExel(miembrosEnExel);
        ArrayList<Miembros> mimbrosAinsertar = new ArrayList<Miembros>();
        Miembros miembroAux = null;
        for (String[] next : datosExel) 
        {
            
            //array de 5 [DNI, nombre_banda,dir,edad,instrumento]
            //System.out.println("Datos de la fila" + r++);
            String dni = next[0];
            String nombreBanda = next[1];
            String dir = next[2];
            int edad = Integer.parseInt(next[3]);
            String instrumento = next[4];
            miembroAux = new Miembros(nombreBanda,dni,dir,edad,instrumento);
            mimbrosAinsertar.add(miembroAux);
            /* 
            for (int c = 0; c < next.length; c++) //Datos de la columna(next)
            {
                System.out.print("[Column " + c + ": " + next + "] ");
            }
            System.out.println();*/
        }
        return mimbrosAinsertar;
    }

    
}

