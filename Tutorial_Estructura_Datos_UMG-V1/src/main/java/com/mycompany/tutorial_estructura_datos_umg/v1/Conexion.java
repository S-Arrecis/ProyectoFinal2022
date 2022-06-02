
package com.mycompany.tutorial_estructura_datos_umg.v1;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    String Nombre,Correo;
    boolean entrar= false;
    private static final String Direccion = "jdbc:mysql://localhost:3306/Proyecto_Final";
    private static final String user = "root";
    private static final String contraseña = "root";
    private PreparedStatement consulta;
    private ResultSet respuesta;
    private  Connection conexion = null;
    private Correo correo = new Correo(); // clase para enviar el codigo de verificacion
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
     
     *  @author Arrecis
     */
    public void insertarDatos(String[] datos, File foto) {
        conexion = null;
        try {
            FileInputStream archivo = new FileInputStream(foto);
            conexion = getConnection();
            consulta = conexion.prepareStatement("INSERT INTO usuario (primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,usuario,password,celular,correo,imagen) values (?,?,?,?,?,?,?,?,?,?)");
            consulta.setString(1, datos[0]);
            consulta.setString(2, datos[1]);
            consulta.setString(3, datos[2]);
            consulta.setString(4, datos[3]);
            consulta.setDate(5, Date.valueOf(datos[4]));
            consulta.setString(6, datos[5]);
            consulta.setString(7, datos[6]);
            consulta.setString(8, datos[7]);
            consulta.setString(9, datos[8]);
            consulta.setBinaryStream(10, archivo, (int) foto.length());

            int resultado = consulta.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Usuario Registrado con éxito!!");
Login login = new Login();            
login.setVisible(true);
File fichero = new File(foto.getPath());

fichero.delete();

                System.out.println("esta es la ruta"+foto);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el usuario, intente otra vez");
            }
            conexion.close();

        } catch (HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la conexión a su Base de Datos");
        }

    }
    /***
     * @param datos recibimos un arreglo de 3 parametros 
     * datos[0] = usuario para iniciar sesion
     * datos[1] = contraseña para iniciar sesion
     * datos[2] = codigo de verificacion para iniciar sesion
     *  @author Arrecis
     */
    public void leerDato(String [] datos) {
        conexion = null;
        try {
            conexion = getConnection();
            consulta = conexion.prepareStatement("SELECT * FROM usuario WHERE usuario=? AND password =?");
            consulta.setString(1, datos[0]);
            consulta.setString(2, datos[1]);

            respuesta = consulta.executeQuery();

            if (respuesta.next()) {
                // obtenemos resultados de la consulta
                JOptionPane.showMessageDialog(null, "Enviando código de validacion al correo "+respuesta.getString("correo"));
                correo.ejecutarCorreo(datos[2],respuesta.getString("correo"));
                this.setEntrar(true);
                this.setCorreo(respuesta.getString("correo"));
                this.setNombre(respuesta.getString("usuario"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta!!");
                 this.setEntrar(false);
            }

            conexion.close();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la conexión a su Base de Datos");
        }

    }

    public boolean isEntrar() {
        return entrar;
    }

    public void setEntrar(boolean entrar) {
        this.entrar = entrar;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
    
    
    
}
