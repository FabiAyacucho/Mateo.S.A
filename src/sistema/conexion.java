package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class conexion {

    public String url = "jdbc:sqlserver://localhost:1433;databaseName=sistema;";
    public String usuario = "UserJava";
    public String pass = "1234";
    public Connection cn = null;
    public Statement st = null;

    public Statement Conectar() {
            
    
    try{
       Connection cn = DriverManager.getConnection(url, usuario, pass);
       st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       
    }
    catch(SQLException i){
        JOptionPane.showMessageDialog(null,i);
    }
        return st;
    }
   }

    

    
    
    