
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class goDB {
    private static String url="";
    public static String dbname="travelmangment";
    private static Connection con;
    private static void setURL()
    { 
        url="jdbc:mysql://localhost:3306/"+ dbname +"?unicode=true&characrterEndcoding=UTF-8";
    }
    private static void setconnection()
    { 
       
        try {
             setURL();
            con=DriverManager.getConnection(url,"root" ,"");
        } catch (SQLException ex) {
            Logger.getLogger(goDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
