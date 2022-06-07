/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial_estructura_datos_umg.v1;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Arrecis
 */
public class Pdf {
    private String nombre;
    private CodeQR fotoQR;
    private final PdfPTable tablaEntrega = new PdfPTable(4);
    

    //String Hora ,String codigo,String punto, String fotoQR,String nombreEmpleado, String codigoEmpleado, String nombre, String dpi, String numero, String direccion, String foto, String serie, String fotoBici
       public void GenerarFormulario(String []datos,File foto) throws FileNotFoundException, BadElementException, IOException{
        
         Document documento = new Document(PageSize.A4,0,10f,0,20f);
         String [] user = new String[2];
         user[0] = datos[5]; 
         user [1] = datos[6];
        try{
            fotoQR = new CodeQR();
            fotoQR.GenerarQR(user);
           PdfWriter.getInstance(documento,new FileOutputStream("FormularioInscripcion.pdf"));
            Image cabeza = Image.getInstance(String.format("header.jpg"));
            cabeza.scaleToFit(245,1000);
            cabeza.scaleAbsoluteWidth(600);
            Image Foto = Image.getInstance(String.format("Codigo.png"));
            Foto.scaleToFit(145,1000);
            Foto.setAbsolutePosition(430f, 460f);
            
            Image FotoUsuario = Image.getInstance(String.format(foto.getAbsolutePath()));
            FotoUsuario.scaleToFit(145,600);
            FotoUsuario.setAbsolutePosition(410f, 250f);
            
            documento.open();
            
            documento.left(100f);
            documento.right(1000f);
            documento.bottom(20f);
            documento.add(cabeza);
            documento.add(Foto);
            documento.add(FotoUsuario);
            //documento.add(FotoBici);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial",28,Font.BOLD,BaseColor.BLACK));
            parrafo.add("\nFormulario de Registro");
            documento.add(parrafo);
//            
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo1.add("\n   ____________________________________________________________________________________________________________________");

            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLUE));
            parrafo1.add("\n\n           Y conoceréis la verdad, y la verdad os hará libres  ");
            parrafo1.add("\n      \t\t\t                                                   Juan 8:32  ");
//////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLACK));
//////            parrafo1.add("\n\n   Codigo: ");
//////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLUE));
//////            parrafo1.add(codigo);
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLACK));
//////////            parrafo1.add("  Punto de Partida: ");
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLUE));
//////////            parrafo1.add(punto);
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLACK));
//////////            parrafo1.add("\n\n   Empleado: ");
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLUE));
//////////            parrafo1.add(nombreEmpleado);
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLACK));
//////////            parrafo1.add("   Codigo Empleado: ");
//////////            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.ITALIC,BaseColor.BLUE));
//////////            parrafo1.add(codigoEmpleado);
            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
           // parrafo1.add("\n    ____________________________________________________________________________________________________________________");
           documento.add(parrafo1);
//            ///datos del cliente
//            
            parrafo1.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo1.add("\n\n\n\n\n\n\n\n\n   ____________________________________________________________________________________________________________________");
            Paragraph par = new Paragraph();
            par.setAlignment(Paragraph.ALIGN_CENTER);
            par.setFont(FontFactory.getFont("Arial",20,Font.BOLD,BaseColor.BLACK));
            par.add("\n\nDatos del Usuario\n");
            documento.add(par);
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo2.add("\n\n Nombre: ");
            parrafo2.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
            parrafo2.add(datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo2.add("\n\n Fecha de Nacimiento: ");
            parrafo2.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
            parrafo2.add(datos[4]);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo2.add("\n\n Numero: ");
            parrafo2.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
            parrafo2.add(datos[7]);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
            parrafo2.add("\n\n Correo: ");
            parrafo2.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
            parrafo2.add(datos[8]);
            documento.add(parrafo2);
//            Paragraph pa = new Paragraph();
//            pa.setAlignment(Paragraph.ALIGN_CENTER);
//            pa.setFont(FontFactory.getFont("Arial",20,Font.BOLD,BaseColor.BLACK));
//            pa.add("\n\nDatos de la Bicicleta");
//            documento.add(pa);
//            Paragraph parrafo22 = new Paragraph();
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
//            parrafo22.add("\n\n\n Marca: ");
//            parrafo22.setAlignment(Paragraph.ALIGN_LEFT);
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
//            parrafo22.add("TRINX");
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
//            parrafo22.add("   Color: ");
//            parrafo22.setAlignment(Paragraph.ALIGN_LEFT);
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
//            parrafo22.add("Blanco y Negro");
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
//            parrafo22.add("\n\n  Linea: ");
//            parrafo22.setAlignment(Paragraph.ALIGN_LEFT);
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
//            parrafo22.add("TR3229");
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLACK));
//            parrafo22.add("   Serie: ");
//            parrafo22.setAlignment(Paragraph.ALIGN_LEFT);
//            parrafo22.setFont(FontFactory.getFont("Arial",18,Font.BOLDITALIC,BaseColor.BLUE));
//            parrafo22.add(serie);
//            
//            
//            documento.add(parrafo22);
           
            documento.close();
            
        }catch(DocumentException e){}//catch(DocumentException | IOException e)
    
    }
}
