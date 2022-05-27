
package com.mycompany.tutorial_estructura_datos_umg.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *  Descripción: Esta clase nos ayuda a conectarnos con MYSQL
 *  creando conexion
 *  
 * @author Arrecis
 */
public class Conexion {
    //?autoReconnet=true&useSSL=false
    private static final String Direccion = "jdbc:mysql://localhost:3306/Proyecto_Final";
    private static final String user = "root";
    private static final String contraseña = "5518";
    
    public Connection getConnection(){
        Connection conexion = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
           conexion = (Connection) DriverManager.getConnection(Direccion,user,contraseña);
           JOptionPane.showMessageDialog(null,"Conexión éxitosa");
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion de tipo: "+e);
        }
        return conexion;
    }
}
