/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmanagement;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import static travelmanagement.connection.con;
/**
 *
 * @author abdel
 */
public class Tourist extends Person{
   private TourTrip currenttrip; 

    public TourTrip getCurrenttrip() {
        return currenttrip;
    }

    public void setCurrenttrip(TourTrip currenttrip) {
        this.currenttrip = currenttrip;
    }
  public void cancle_comingtrip() throws Exception{
      
 try
{
   connection.setConnection();

  connection.runNoNQuery("delete from tourist where Tourist_id='" +TouristsInterface.jTextField17.getText()+"'"+ "and Tripname='"+TouristsInterface.jTextField16.getText()+"'");

  JOptionPane.showMessageDialog(null,"Delete successfully");

}
 
   catch (Exception ex) {
         JOptionPane.showMessageDialog(null,ex);
       }
  
 }

    @Override
    public void add() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              try{
                connection.setConnection();
            connection.runNoNQuery("insert into tourist (Tourist_id,Tourist_name,Tourist_age,Tripname,Tripdate) values('"+Integer.valueOf(TouristsInterface.jTextField2.getText())+"','"+TouristsInterface.jTextField3.getText()+"','"+Integer.valueOf(TouristsInterface.jTextField6.getText())+"','"+TouristsInterface.jTextField4.getText()+"','"+TouristsInterface.jTextField5.getText()+"')");
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
String updateQuery = "UPDATE `tourist` SET `Tourist_name`=?,`Tourist_age`=?,`Tripname`=? ,`Tripdate`=? where Tourist_id=?";
  PreparedStatement p = connection.con.prepareStatement(updateQuery);
  p.setString(1,TouristsInterface.jTextField7.getText());
  p.setInt(2,Integer.valueOf(TouristsInterface.jTextField8.getText()));
  p.setString(3,TouristsInterface.jTextField9.getText());
  p.setString(4,TouristsInterface.jTextField10.getText());
  p.setInt(5,Integer.valueOf(TouristsInterface.jTextField11.getText()));
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            connection.setConnection();
            PreparedStatement ps= con.prepareStatement("select * from tourist where Tourist_id ='"+Integer.valueOf(TouristsInterface.jTextField13.getText())+"'");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)TouristsInterface.jTable1.getModel();
            tm.setRowCount(0);
            while(rs.next()){
            Object o[]={rs.getInt("Tourist_id"),rs.getString("Tourist_name"),rs.getInt("Tourist_age"),rs.getString("Tripname"),rs.getString("Tripdate")};
            tm.addRow(o);
            }
            JOptionPane.showMessageDialog(null,"Display successfully");
    }
     catch(Exception ex){
              JOptionPane.showMessageDialog(null,"error");
    }
    
    }

    public void postpone_trip()
 { 
   try {
           connection.setConnection();
           PreparedStatement ps= con.prepareStatement("select * from trips where Trip_name ='"+TouristsInterface.jTextField14.getText()+"'");
           ResultSet rs=ps.executeQuery();
           String da;
           while(rs.next()){
           da = rs.getString("Trip_date");
           TouristsInterface.jComboBox1.addItem(da);
           }
           
           String updateQuery =("UPDATE `tourist` SET `Tripdate` WHERE  Tourist_id=?");
            PreparedStatement p = connection.con.prepareStatement(updateQuery);
                  p.setString(1,TouristsInterface.jComboBox1.getSelectedItem().toString());
                 p.setString(2,TouristsInterface.jTextField14.getText());
             p.setInt(3,Integer.valueOf(TouristsInterface.jTextField15.getText()));
         p.executeUpdate();
        connection.con.close();
       //  JOptionPane.showMessageDialog(null,"postpone successfully"); 
         
       } 
       catch (Exception ex) {
          JOptionPane.showMessageDialog(null,ex);
       }    

 } 
    
    
    
    @Override
    public void delete() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try
{
           connection.setConnection();
           connection.runNoNQuery("delete from tourist where Tourist_id = " +Integer.valueOf(TouristsInterface.jTextField12.getText()));
             JOptionPane.showMessageDialog(null,"Delete successfully"); 
    }
    catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
    }
    }
    
    
    
    
    
}
