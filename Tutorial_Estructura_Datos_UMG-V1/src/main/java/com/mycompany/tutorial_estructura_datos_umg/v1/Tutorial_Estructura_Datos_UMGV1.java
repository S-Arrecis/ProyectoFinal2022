/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tutorial_estructura_datos_umg.v1;

import java.sql.Connection;

/**
 *
 * @author Arrecis
 */
public class Tutorial_Estructura_Datos_UMGV1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Conexion a = new Conexion();
       Correo correo = new Correo();
       Connection connection = a.getConnection();
       correo.ejecutarCorreo("667788", "kpriceh_b839y@hxsni.com");
    }
}
