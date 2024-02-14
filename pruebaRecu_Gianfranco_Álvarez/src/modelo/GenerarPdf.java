/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author gianf
 */
public class GenerarPdf {

    public static boolean writePDFSalas() {
        //document pdf
        Document document = new Document();
        boolean documentoGeneradoOk = false;
        try {
            String path = new File(".").getCanonicalPath();
            String FILE_NAME = path + "/salas.pdf";

            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph titulo = new Paragraph();
            titulo.add("Listado de Salas disponibles");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add( Chunk.NEWLINE ); 
            document.add( Chunk.NEWLINE );

            Paragraph tabla = new Paragraph();
            
            tabla.add("Nombre sala         Aforo      Precio        localidad ");
            document.add(tabla);
            document.add( Chunk.NEWLINE );
            Paragraph datos = new Paragraph();
            String registro = "";
            for (Salas item : ConexionesBBDD.obtenerSalas()) 
            {
                registro = item.getNombreSala() + "               " + item.getAforo() + "                 " + item.getPrecio() + "           " + item.getLocalidad();
                datos.add(registro);
                datos.add(Chunk.NEWLINE);
            }
            
            document.add(datos);
        
            document.close();
            documentoGeneradoOk = true;
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentoGeneradoOk;
    }
}
