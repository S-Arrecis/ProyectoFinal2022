
package tutorial_estructura_datos_umg_v1.pkg0;

import java.sql.Connection;

/**
 *
 * @author Arrecis
 */
public class Tutorial_Estructura_Datos_UMG_V10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Conexion a = new Conexion();
        Connection connection = a.getConnection();
    }
    
}
