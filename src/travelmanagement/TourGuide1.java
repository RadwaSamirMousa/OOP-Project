/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmanagement;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static travelmanagement.connection.con;
/**
 *
 * @author abdel
 */
public class TourGuide1 extends Person {

private int Tourguide_salary;


    public void setTourguide_salary(int Tourguide_salary) {
        this.Tourguide_salary = Tourguide_salary;
    }


    public int getTourguide_salary() {
        return Tourguide_salary;
    }

    
  public void assign() throws SQLException{
      
      connection.setConnection();
     
     //connection.runNoNQuery("insert into tourguide (Assign_trip) values('"+GuidesInterface.jTextField12.getText()+"')where Tourguide_id='"+Integer.valueOf(GuidesInterface.jTextField13.getText())+"'");
             //+"' AND Assign_trip is null'"+"'");
     String updateQuery = "UPDATE `tourguide` SET `Assign_trip`=? where Tourguide_id=? and Assign_trip=? ";
  PreparedStatement p = connection.con.prepareStatement(updateQuery);
  p.setString(1,GuidesInterface.jTextField12.getText());
  p.setInt(2,Integer.valueOf(GuidesInterface.jTextField13.getText()));
p.setString(3,"Not Assigned");

  p.executeUpdate();
    connection.con.close();
  
  }
    public TourGuide1 search(int Id){
    if(this.getId()==Id)
    return this;
     
    else
        return null;
    
  
    }

    @Override
    public void add() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          try{
                connection.setConnection();
            connection.runNoNQuery("insert into tourguide (Tourguide_id,Tourguide_name,Tourguide_age,Tourguide_salary,Assign_trip) values('"+Integer.valueOf(GuidesInterface.jTextField2.getText())+"','"+GuidesInterface.jTextField3.getText()+"','"+Integer.valueOf(GuidesInterface.jTextField4.getText())+"','"+Integer.valueOf(GuidesInterface.jTextField5.getText())+"','"+"Not Assigned"+"')");
            JOptionPane.showMessageDialog(null,"ADD successfully");
            }
            catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Erorr in connection");
            }
    }
 @Override
    public void edit() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
try{
connection.setConnection();
String updateQuery = "UPDATE `tourguide` SET `Tourguide_name`=?,`Tourguide_age`=?,`Tourguide_salary`=? where Tourguide_id=?";
  PreparedStatement p = connection.con.prepareStatement(updateQuery);
 p.setString(1, GuidesInterface.jTextField7.getText());
 p.setInt(2,Integer.valueOf(GuidesInterface.jTextField8.getText()));
 p.setInt(3,Integer.valueOf(GuidesInterface.jTextField9.getText()));
 p.setInt(4,Integer.valueOf(GuidesInterface.jTextField6.getText()));
      p.executeUpdate();
        connection.con.close();  
     JOptionPane.showMessageDialog(null,"Update successfully");
}


  catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
  }




         
    }

    @Override
    public void view() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
            connection.setConnection();
            PreparedStatement ps= con.prepareStatement("select * from tourguide where Tourguide_id ='"+Integer.valueOf(GuidesInterface.jTextField11.getText())+"'");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)GuidesInterface.table1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
            Object o[]={rs.getInt("Tourguide_id"),rs.getString("Tourguide_name"),rs.getInt("Tourguide_age"),rs.getInt("Tourguide_salary")};
            tm.addRow(o);
            }
            JOptionPane.showMessageDialog(null,"Display successfully");
    }
     catch(Exception ex){
              JOptionPane.showMessageDialog(null,"error");
    }
    }

    @Override
    public void delete() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  try
{
        connection.setConnection();
           connection.runNoNQuery("delete from tourguide where Tourguide_id = "+Integer.valueOf(GuidesInterface.jTextField10.getText()));
             JOptionPane.showMessageDialog(null,"Delete successfully");
    
    }
    catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
    }

    }
    
    
    
}
