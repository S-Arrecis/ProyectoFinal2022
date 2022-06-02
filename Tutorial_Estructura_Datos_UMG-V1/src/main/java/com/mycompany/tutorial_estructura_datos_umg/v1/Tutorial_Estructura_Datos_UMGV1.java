/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tutorial_estructura_datos_umg.v1;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;

/**
 *
 * @author Arrecis
 */
public class Tutorial_Estructura_Datos_UMGV1 {

    public static void main(String[] args) {
        
//        File foto = new File("programacion.png");
//        String datos[] = {"Maria", "Roberta", "Margot", "Valenzuela", "1999-08-02", "mariam", "123", "77889944", "kpriceh_b839y@hxsni.com"};
//        String leer[] = {"mariam", "123", "777332"};
//        System.out.println("Hello World! (0_0)/");
//        Conexion a = new Conexion();
//        //Correo correo = new Correo();
//        Connection connection = a.getConnection();
//        //a.insertarDatos(datos, foto);
//        //a.leerDato(leer);
//        a.leerDato(leer);
//        //a.insertarDatos(datos, foto);
//        //correo.ejecutarCorreo("667788", "kpriceh_b839y@hxsni.com");
            CodeQR qr = new CodeQR();
            String a [] = {"Margot","123"};
            qr.GenerarQR(a);
    }

}
