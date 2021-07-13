
package travelmanagement;

import java.sql.*;
import javax.swing.*;


/**
 *
 * @author Alaa Sayed
 */
public class connection {
    private static String url="";
     public static Connection con;
    private static void setURL()
    {
        url="jdbc:mysql://localhost:3306/travelmanagement";
    }
    public static void setConnection()
    {
        try {
            setURL();
            con=DriverManager.getConnection(url,"root","");
            
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    public static boolean runNoNQuery(String s) throws SQLException
    {
     
        try
        {
           connection.setConnection();
           Statement stat=con.createStatement();
           stat.execute(s);
           con.close();
           return true;
        
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

   
}
