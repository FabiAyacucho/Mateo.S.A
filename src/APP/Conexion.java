
package APP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabian
 */
public class Conexion {
    
    public static Connection getConexion(){
       
      String url = "jdbc:sqlserver://localhost:1433;"
              + "database=MateoHermanos;"
              + "user=sa;"
              +"password=Fitoaya2287;"
              + "loginTimeout=30;";
              
      try{
        Connection con = DriverManager.getConnection(url);
        return con;
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
    
          }
      }
     }

    

