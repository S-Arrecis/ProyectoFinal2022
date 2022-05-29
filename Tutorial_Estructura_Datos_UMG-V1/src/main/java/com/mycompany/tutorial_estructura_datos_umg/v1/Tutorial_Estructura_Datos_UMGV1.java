/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tutorial_estructura_datos_umg.v1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Arrecis
 */
public class Tutorial_Estructura_Datos_UMGV1 {
    
    
    
    public static void main(String[] args) {
        File foto = new File("d.txt");
        String datos[] = {"Mario", "Roberto", "Martinez", "Arriaga", "1999-10-22", "mroberto", "12345", "88885577", "kpriceh_b839y@hxsni.com"};

        System.out.println("Hello World! (0_0)/");

        Conexion a = new Conexion();
        //Correo correo = new Correo();
        Connection connection = a.getConnection();
        //a.insertarDatos(datos);

       

        //a.insertarDatos(datos, foto);
       //correo.ejecutarCorreo("667788", "kpriceh_b839y@hxsni.com");
    }
    
    public static void foto(){
        
    }
}
