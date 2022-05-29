
package com.mycompany.tutorial_estructura_datos_umg.v1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private PreparedStatement consulta;
    private  Connection conexion = null;
    
    public Connection getConnection(){
        conexion = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
           conexion = (Connection) DriverManager.getConnection(Direccion,user,contraseña);
           //JOptionPane.showMessageDialog(null,"Conexión éxitosa");
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion de tipo: "+e);
        }
        return conexion;
    }
    /***
     * Descripcion: Este meétodo recibe 2 parametros para la insersion de datos
     * en la base de datos usuarios
     * @param datos un Array de String donde contiene datos personales
     *  (primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,usuario,password,celular,correo)
     * @param foto enviar la foto en tipo archivo usando el parametro File foto = escoger.getSelectFile();
     */
    public void insertarDatos(String [] datos , File foto ){
        conexion = null;
        try {
            FileInputStream archivo = new FileInputStream(foto);
            conexion = getConnection();
            consulta = conexion.prepareStatement("INSERT INTO usuario (primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,usuario,password,celular,correo,imagen) values (?,?,?,?,?,?,?,?,?,?)");
            consulta.setString(1,datos[0]);
            consulta.setString(2,datos[1]);
            consulta.setString(3,datos[2]);
            consulta.setString(4,datos[3]);
            consulta.setDate(5, Date.valueOf(datos[4]));
            consulta.setString(6,datos[5]);
            consulta.setString(7,datos[6]);
            consulta.setString(8,datos[7]);
            consulta.setString(9,datos[8]);
            consulta.setBinaryStream(10, archivo, (int)foto.length());
            
            int resultado = consulta.executeUpdate();
            
            if(resultado >0){
                JOptionPane.showMessageDialog(null,"Datos insertados con éxito!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"No se pudo insertar los datos intente otra vez");
            }
            conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas con la conexión a su Base de Datos");
        }


    }
    
}
